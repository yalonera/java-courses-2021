package by.part8.internal.example8;

public abstract class EntityAuditor extends AuditorBase {

  @Override
  public void auditEntityFieldSet() {
    createLogRow();
    calculatePrice();
  }

  protected abstract void createLogRow();

  protected abstract void calculatePrice();
}
