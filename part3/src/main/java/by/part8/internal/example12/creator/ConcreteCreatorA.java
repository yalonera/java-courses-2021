package by.part8.internal.example12.creator;

import by.part8.internal.example12.ConcreteProductA;
import by.part8.internal.example12.Product;

public class ConcreteCreatorA implements Creator {

  @Override
  public Product factoryMethod() {
    return new ConcreteProductA();
  }
}
