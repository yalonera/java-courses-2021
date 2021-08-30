package by.part6.service2.repository;

import by.part6.service.model.Customer;
import by.part6.service.model.Order;
import by.part6.service.model.OrderItem;
import by.part6.service.model.PaymentInfo;
import by.part6.service.model.Product;
import java.util.List;

public interface CustomerRepository {

  List<Product> findProducts();

  List<Customer> findCustomers();

  List<Order> findOrders(int count);

  List<PaymentInfo> findPaymentInfos();

  List<OrderItem> findOrderItems(int count);
}
