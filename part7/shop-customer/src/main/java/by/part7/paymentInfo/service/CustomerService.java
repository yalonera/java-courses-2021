package by.part7.paymentInfo.service;

import by.part7.paymentInfo.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

  Flux<Customer> findCustomers();

  Mono<Customer> findCustomerById(int id);
}
