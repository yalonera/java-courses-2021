package by.part6.service1;

import by.part6.service.model.Order;
import by.part6.service1.model.ProductResponse;
import by.part6.service1.service.CacheCustomerService;
import by.part6.service1.service.CustomerService;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactivefeign.webclient.WebReactiveFeign;
import reactor.core.publisher.Mono;
import reactor.netty.NettyOutbound;
import reactor.netty.http.server.HttpServer;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
import reactor.netty.http.server.logging.AccessLog;

public class Service1Main {

  private static final Logger LOGGER = LoggerFactory.getLogger(Service1Main.class);

  public static void main(String[] args) {
    final CustomerService target = WebReactiveFeign
        .<CustomerService>builder()
        .target(CustomerService.class, "http://localhost:8889");
    final CustomerService customerService = new CacheCustomerService(target);

    HttpServer.create()
        .route(routes -> routes
            .get("/status", (request, response) -> response.sendString(Mono.just("ok")))
            .get("/products", (request, response) -> products(customerService, request, response))
            .get("/orders/{count}", (request, response) -> orders(customerService, request, response)))
        .accessLog(true, x -> AccessLog.create("method={}, uri={}", x.method(), x.uri()))
        .port(8888)
        .bindNow()
        .onDispose()
        .block();
  }

  private static NettyOutbound products(
      CustomerService customerService, HttpServerRequest request, HttpServerResponse response) {
    final Mono<ProductResponse> value = customerService.findProducts()
        .collectList()
        .onErrorResume(e -> {
          LOGGER.error("Service2 products call error", e);
          return Mono.just(Collections.emptyList());
        })
        .map(x -> new ProductResponse(x, "changed by service1"));
    return Utils.json(response, value);
  }

  private static NettyOutbound orders(
      CustomerService customerService, HttpServerRequest request, HttpServerResponse response) {
    final int count = Integer.parseInt(Objects.requireNonNull(request.param("count")));
    final Mono<List<Order>> value = customerService.findOrders(count)
        .collectList()
        .onErrorResume(e -> {
          LOGGER.error("Service2 orders call error", e);
          return Mono.just(Collections.emptyList());
        });
    return Utils.json(response, value);
  }
}
