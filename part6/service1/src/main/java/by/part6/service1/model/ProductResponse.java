package by.part6.service1.model;

import by.part6.service.model.Product;
import java.util.List;

public class ProductResponse {

  private final List<Product> products;
  private final String description;

  public ProductResponse(List<Product> products, String description) {
    this.products = products;
    this.description = description;
  }

  public List<Product> getProducts() {
    return products;
  }

  public String getDescription() {
    return description;
  }
}
