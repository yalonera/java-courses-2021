package by.part6;

public class Example1 {

  interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
      return Math.sqrt(a);
    }
  }

  public static void main(String[] args) {
    new Example1().execute();
  }

  private void execute() {
    Formula formula = new Formula() {
      @Override
      public double calculate(int a) {
        System.out.println(this);
        return sqrt(a * 100);
      }
    };
    System.out.println(formula.calculate(100));     // 100.0
    System.out.println(formula.sqrt(16));           // 4.0
  }
}
