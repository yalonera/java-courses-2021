package by.part7.product.service;

import by.part7.product.model.Product;
import by.part7.product.repository.ProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DefaultProductService implements ProductService {

  private final ProductRepository repository;

  public DefaultProductService(ProductRepository repository) {
    this.repository = repository;
  }

  @Override
  public Flux<Product> findProduct() {
    return Flux.fromIterable(repository.findAll());
  }

  @Override
  public Mono<Product> findProductById(int id) {
    return Mono.fromCallable(() -> repository.findById(id));
  }
}
