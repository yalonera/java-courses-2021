package by.part6.service1.service;

import by.part6.service.model.Order;
import by.part6.service.model.Product;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import reactor.core.publisher.Flux;

public class CacheCustomerService implements CustomerService {

  private final CustomerService delegate;
  private Flux<Product> products;

  public CacheCustomerService(CustomerService delegate) {
    this.delegate = delegate;
    this.products = delegate.findProducts()
        .cache(Duration.of(10, ChronoUnit.SECONDS));
  }

  @Override
  public Flux<Product> findProducts() {
    return products;
  }

  @Override
  public Flux<Order> findOrders(Integer count) {
    return delegate.findOrders(count);
  }
}
