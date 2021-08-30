package by.part10.internal.example3;

public class ConcreteStrategySubtract implements Strategy {

  public double execute(int a, int b) {
    System.out.println("Called ConcreteStrategySubtract's execute()");
    return a - b;  // Do a subtraction with a and b
  }
}