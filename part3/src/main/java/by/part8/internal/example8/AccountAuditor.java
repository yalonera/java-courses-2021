package by.part8.internal.example8;

public class AccountAuditor extends AuditorBase {

  protected void createLogRow() {
// реализация
  }

  @Override
  void auditEntityFieldSet() {
    createLogRow();
  }
}
