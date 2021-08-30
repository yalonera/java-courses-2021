package by.part7.order.repository;

import by.part7.order.model.Order;
import java.util.List;

public interface OrderRepository {

  List<Order> findAll();
}
