package by.part7.product.config;

import by.part7.product.controller.ProductController;
import by.part7.product.repository.JpaProductRepository;
import by.part7.product.repository.ProductRepository;
import by.part7.product.service.DefaultProductService;
import by.part7.product.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

  @Bean
  public ProductRepository productRepository() {
    return new JpaProductRepository();
  }

  @Bean
  public ProductService productService() {
    return new DefaultProductService(productRepository());
  }

  @Bean
  public ProductController productController() {
    return new ProductController(productService());
  }
}
