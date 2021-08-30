package by.part10.internal.example3;

public class ConcreteStrategyAdd implements Strategy {

  public double execute(int a, int b) {
    System.out.println("Called ConcreteStrategyAdd's execute()");
    return a + b;  // Do an addition with a and b
  }
}
 