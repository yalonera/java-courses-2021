package by.part10;

import by.part10.internal.example3.ConcreteStrategyAdd;
import by.part10.internal.example3.ConcreteStrategyDivide;
import by.part10.internal.example3.ConcreteStrategyMultiply;
import by.part10.internal.example3.ConcreteStrategySubtract;
import by.part10.internal.example3.Context;

public class Example3 {

  public static void main(String[] args) {

    Context context = new Context();

    context.setStrategy(new ConcreteStrategyAdd());
    int resultA = (int) context.executeStrategy(3, 4);
    System.out.println("Result A : " + resultA);

    context.setStrategy(new ConcreteStrategySubtract());
    int resultB = (int) context.executeStrategy(3, 4);
    System.out.println("Result B : " + resultB);

    context.setStrategy(new ConcreteStrategyMultiply());
    int resultC = (int) context.executeStrategy(3, 4);
    System.out.println("Result C : " + resultC);

    context.setStrategy(new ConcreteStrategyDivide());
    int resultD = (int) context.executeStrategy(12, 4);
    System.out.println("Result D : " + resultD);
  }
}
