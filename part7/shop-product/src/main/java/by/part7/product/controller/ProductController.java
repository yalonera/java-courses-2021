package by.part7.product.controller;

import by.part7.product.model.Product;
import by.part7.product.service.ProductService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @ResponseBody
  @GetMapping(value = "/")
  public Mono<List<Product>> findProducts() {
    return productService.findProduct().collectList();
  }

  @ResponseBody
  @GetMapping(value = "/{id}")
  public Mono<Product> findProductById(@PathVariable("id") Integer id) {
    return productService.findProductById(id);
  }
}
