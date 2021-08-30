package by.part8.internal.example12.creator;

import by.part8.internal.example12.ConcreteProductB;
import by.part8.internal.example12.Product;

public class ConcreteCreatorB implements Creator {

  @Override
  public Product factoryMethod() {
    return new ConcreteProductB();
  }
}
