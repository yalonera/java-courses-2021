package by.part10.proxy;

public class ExpensiveObjectProxy implements ExpensiveObject {

  private static ExpensiveObject object;

  @Override
  public void process01() {
    if (object == null) {
      object = new ExpensiveObjectImpl();
    }
    object.process01();
  }
}
