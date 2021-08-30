package by.part6.service2.service;

import by.part6.service.model.Order;
import by.part6.service.model.Product;
import reactor.core.publisher.Flux;

public interface CustomerService {


  Flux<Product> findProducts();



  Flux<Order> findOrders(Integer count);
}
