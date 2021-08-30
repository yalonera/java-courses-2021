package by.part6.service2;

import by.part6.service.model.Order;
import by.part6.service.model.Product;
import by.part6.service2.repository.CustomerRepository;
import by.part6.service2.repository.DefaultCustomerRepository;
import by.part6.service2.service.CustomerService;
import by.part6.service2.service.DefaultCustomerService;
import java.util.List;
import java.util.Objects;
import reactor.core.publisher.Mono;
import reactor.netty.NettyOutbound;
import reactor.netty.http.server.HttpServer;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
import reactor.netty.http.server.logging.AccessLog;

public class Service2Main {

  public static void main(String[] args) {
    final CustomerRepository repository = new DefaultCustomerRepository();
    final CustomerService customerService = new DefaultCustomerService(repository);

    HttpServer.create()
        .route(routes -> routes
            .get("/status", (request, response) -> response.sendString(Mono.just("ok")))
            .get("/products", (request, response) -> products(customerService, request, response))
            .get("/orders/{count}", (request, response) -> orders(customerService, request, response)))
        .accessLog(true, x -> AccessLog.create("method={}, uri={}", x.method(), x.uri()))
        .port(8889)
        .bindNow()
        .onDispose()
        .block();
  }

  private static NettyOutbound products(
      CustomerService customerService, HttpServerRequest request, HttpServerResponse response) {
    final Mono<List<Product>> value = customerService.findProducts()
        .collectList();
    return Utils.json(response, value);
  }

  private static NettyOutbound orders(
      CustomerService customerService, HttpServerRequest request, HttpServerResponse response) {
    final int count = Integer.parseInt(Objects.requireNonNull(request.param("count")));
    final Mono<List<Order>> value = customerService.findOrders(count)
        .collectList();
    return Utils.json(response, value);
  }
}
