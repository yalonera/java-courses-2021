package by.part7.order.service;

import by.part7.order.dto.CustomerDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

  @RequestLine("GET /customer")
  @Headers("Content-Type: application/json")
  Flux<CustomerDto> findCustomers();

  @RequestLine("GET /customer/{id}")
  @Headers("Content-Type: application/json")
  Mono<CustomerDto> findCustomer(@Param("id") int id);
}
