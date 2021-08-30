package by.part7.product;

import by.part7.product.config.ProductConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = ProductConfig.class)
public class ProductApp {

  public static void main(String[] args) {
    SpringApplication.run(ProductApp.class, args);
  }
}
