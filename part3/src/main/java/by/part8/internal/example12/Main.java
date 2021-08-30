package by.part8.internal.example12;

import by.part8.internal.example12.creator.ConcreteCreatorA;
import by.part8.internal.example12.creator.ConcreteCreatorB;
import by.part8.internal.example12.creator.Creator;

public class Main {

  public static void main(String[] args) {
    // an array of creators
    Creator[] creators = {new ConcreteCreatorA(), new ConcreteCreatorB()};
    // iterate over creators and create products
    for (Creator creator : creators) {
      Product product = creator.factoryMethod();
      System.out.printf("Created {%s}\n", product.getClass());
    }
  }
}
