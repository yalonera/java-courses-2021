package by.part8.internal.example2;

import by.part8.internal.Product;

public class Product2ValidatorImpl implements ProductValidator {

  @Override
  public boolean isValid(Product product) {
    return product.getPrice() > 1000;
  }
}
