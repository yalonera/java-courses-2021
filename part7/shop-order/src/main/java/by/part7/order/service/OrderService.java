package by.part7.order.service;

import by.part7.order.dto.OrdersDto;
import by.part7.order.model.Order;
import reactor.core.publisher.Flux;

public interface OrderService {

  Flux<Order> findOrders();

  Flux<OrdersDto> findOrdersDto();
}
