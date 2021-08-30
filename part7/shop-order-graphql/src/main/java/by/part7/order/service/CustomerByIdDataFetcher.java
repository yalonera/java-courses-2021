package by.part7.order.service;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class CustomerByIdDataFetcher implements DataFetcher<CompletableFuture<Map<String, Object>>> {

  private final CustomerService customerService;

  public CustomerByIdDataFetcher(CustomerService customerService) {
    this.customerService = customerService;
  }

  @Override
  public CompletableFuture<Map<String, Object>> get(DataFetchingEnvironment env) {
    final int customerId = env.getArgument("customer_id");
    return customerService.findCustomer(customerId).toFuture();
  }
}
