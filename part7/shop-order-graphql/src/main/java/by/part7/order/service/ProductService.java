package by.part7.order.service;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import java.util.Map;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

  @RequestLine("GET /product")
  @Headers("Content-Type: application/json")
  Flux<Map<String, Object>> findProducts();

  @RequestLine("GET /product/{id}")
  @Headers("Content-Type: application/json")
  Mono<Map<String, Object>> findProduct(@Param("id") int id);
}
