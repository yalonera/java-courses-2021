package by.part7.paymentInfo.repository;

import by.part7.paymentInfo.model.Customer;
import java.util.List;

public interface CustomerRepository {

  List<Customer> findAll();

  Customer findById(int id);
}
