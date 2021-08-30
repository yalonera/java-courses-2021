package by.part7.order.service;

import by.part7.order.dto.ProductDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

  @RequestLine("GET /product")
  @Headers("Content-Type: application/json")
  Flux<ProductDto> findProducts();

  @RequestLine("GET /product/{id}")
  @Headers("Content-Type: application/json")
  Mono<ProductDto> findProduct(@Param("id") int id);
}
