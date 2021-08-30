package by.part10.proxy;

public class ExpensiveObjectImpl implements ExpensiveObject {

  public ExpensiveObjectImpl() {
    heavyInitialConfiguration();
  }

  @Override
  public void process01() {
    System.out.println("processing complete.");
  }

  private void heavyInitialConfiguration() {
    System.out.println("Loading initial configuration...");
  }
}
