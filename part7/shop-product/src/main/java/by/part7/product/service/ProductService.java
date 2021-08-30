package by.part7.product.service;

import by.part7.product.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

  Flux<Product> findProduct();

  Mono<Product> findProductById(int id);
}
