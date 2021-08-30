package by.part7.order.service;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import java.util.Map;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

  @RequestLine("GET /customer")
  @Headers("Content-Type: application/json")
  Flux<Map<String, Object>> findCustomers();

  @RequestLine("GET /customer/{id}")
  @Headers("Content-Type: application/json")
  Mono<Map<String, Object>> findCustomer(@Param("id") int id);
}
