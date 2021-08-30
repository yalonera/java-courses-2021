package by.part7.paymentInfo;

import by.part7.paymentInfo.config.CustomerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = CustomerConfig.class)
public class CustomerApp {

  public static void main(String[] args) {
    SpringApplication.run(CustomerApp.class, args);
  }
}
