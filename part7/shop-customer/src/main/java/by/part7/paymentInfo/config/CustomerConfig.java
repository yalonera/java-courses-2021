package by.part7.paymentInfo.config;

import by.part7.paymentInfo.controller.CustomerController;
import by.part7.paymentInfo.repository.CustomerRepository;
import by.part7.paymentInfo.repository.JpaCustomerRepository;
import by.part7.paymentInfo.service.CustomerService;
import by.part7.paymentInfo.service.DefaultCustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

  @Bean
  public CustomerRepository customerRepository() {
//    return new DefaultCustomerRepository();
    return new JpaCustomerRepository();
  }

  @Bean
  public CustomerService customerService() {
    return new DefaultCustomerService(customerRepository());
  }

  @Bean
  public CustomerController customerController() {
    return new CustomerController(customerService());
  }
}
