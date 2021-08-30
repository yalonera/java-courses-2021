package by.part7.order;

import by.part7.order.config.OrderGraphqlConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = OrderGraphqlConfig.class)
public class OrderApp {

  public static void main(String[] args) {
    SpringApplication.run(OrderApp.class, args);
  }
}
