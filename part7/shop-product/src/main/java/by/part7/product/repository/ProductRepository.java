package by.part7.product.repository;

import by.part7.product.model.Product;
import java.util.List;

public interface ProductRepository {

  List<Product> findAll();

  Product findById(int id);
}
