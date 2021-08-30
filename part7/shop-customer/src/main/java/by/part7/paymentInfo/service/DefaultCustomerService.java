package by.part7.paymentInfo.service;

import by.part7.paymentInfo.model.Customer;
import by.part7.paymentInfo.repository.CustomerRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DefaultCustomerService implements CustomerService {

  private final CustomerRepository repository;

  public DefaultCustomerService(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public Flux<Customer> findCustomers() {
    return Flux.fromIterable(repository.findAll());
  }

  @Override
  public Mono<Customer> findCustomerById(int id) {
    return Mono.fromCallable(() -> repository.findById(id));
  }
}
