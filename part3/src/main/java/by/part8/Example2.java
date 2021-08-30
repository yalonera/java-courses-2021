package by.part8;

import by.part8.internal.Product;
import by.part8.internal.example2.Product1ValidatorImpl;
import by.part8.internal.example2.Product2ValidatorImpl;
import by.part8.internal.example2.ProductValidator;

public class Example2 {

  public static void main(String[] args) {
    bad();
    good();
  }

  private static void bad() {
    Product product1 = new Product();
    product1.setPrice(100);
    boolean isValid1 = product1.isValid();

    Product product2 = new Product();
    product2.setPrice(100);
    boolean isValid2 = product2.isValid(true, true);
  }

  private static void good() {
    ProductValidator productValidator1 = new Product1ValidatorImpl();
    Product product1 = new Product();
    product1.setPrice(100);
    boolean isValid1 = productValidator1.isValid(product1);

    ProductValidator productValidator2 = new Product2ValidatorImpl();

    Product product2 = new Product();
    product2.setPrice(100);
    boolean isValid2 = productValidator2.isValid(product2);
  }
}
