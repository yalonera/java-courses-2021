package by.part7.paymentInfo.controller;

import by.part7.paymentInfo.model.Customer;
import by.part7.paymentInfo.service.CustomerService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping(value = "/")
  @ResponseBody
  public Mono<List<Customer>> findCustomers() {
    return customerService.findCustomers().collectList();
  }

  @GetMapping(value = "/{id}")
  @ResponseBody
  public Mono<Customer> findCustomerById(@PathVariable("id") int id) {
    return customerService.findCustomerById(id);
  }
}
