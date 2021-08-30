package by.part6.service2.service;

import by.part6.service.model.Order;
import by.part6.service.model.Product;
import by.part6.service2.repository.CustomerRepository;
import reactor.core.publisher.Flux;

public class DefaultCustomerService implements CustomerService {

  private final CustomerRepository repository;

  public DefaultCustomerService(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public Flux<Product> findProducts() {
    return Flux.fromIterable(repository.findProducts());
  }

  @Override
  public Flux<Order> findOrders(Integer count) {
    return Flux.fromIterable(repository.findOrders(count));
  }
}
