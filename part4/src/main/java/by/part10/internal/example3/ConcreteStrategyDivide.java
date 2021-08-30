package by.part10.internal.example3;

public class ConcreteStrategyDivide implements Strategy {

  public double execute(int a, int b) {
    System.out.println("Called ConcreteStrategyMultiply's execute()");
    return a / b;   // Do a multiplication with a and b
  }
}