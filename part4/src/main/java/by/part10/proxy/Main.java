package by.part10.proxy;

public class Main {

  public static void main(String[] args) {
    System.out.println("Example 1:");
    ExpensiveObject example1 = new ExpensiveObjectProxy();
    example1.process01();
    example1.process01();

    System.out.println("Example 2:");
    ExpensiveObject example2 = ExpensiveObjectHandler.create(example1);
    example2.process01();
    example2.process01();
  }
}
