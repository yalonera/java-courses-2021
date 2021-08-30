package by.part8;

public class Example8 {

  public abstract class AuditorBase {

    abstract void auditEntityFieldSet();
  }

  public abstract class EntityAuditor extends AuditorBase {

    @Override
    public void auditEntityFieldSet() {
      createLogRow();
      calculatePrice();
    }

    protected abstract void createLogRow();

    protected abstract void calculatePrice();
  }

  public class AccountAuditor extends EntityAuditor {

    @Override
    protected void createLogRow() {
// реализация
    }

    @Override
    protected void calculatePrice() {
      //пусто
    }
  }

  public class ProductAuditor extends EntityAuditor {

    @Override
    protected void createLogRow() {
// реализация
    }

    @Override
    protected void calculatePrice() {
      //реализация
    }
  }
}
