package by.part6.service1.service;

import by.part6.service.model.Order;
import by.part6.service.model.Product;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import reactor.core.publisher.Flux;

public interface CustomerService {

  @RequestLine("GET /products")
  @Headers("Content-Type: application/json")
  Flux<Product> findProducts();

  @RequestLine("GET /orders/{count}")
  @Headers("Content-Type: application/json")
  Flux<Order> findOrders(@Param("count") Integer count);
}
