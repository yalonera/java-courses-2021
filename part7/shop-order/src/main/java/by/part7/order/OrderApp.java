package by.part7.order;

import by.part7.order.config.OrderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = OrderConfig.class)
public class OrderApp {

  public static void main(String[] args) {
    SpringApplication.run(OrderApp.class, args);
  }
}
