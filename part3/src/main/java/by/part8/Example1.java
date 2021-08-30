package by.part8;

import by.part8.internal.Account;
import by.part8.internal.Role;
import by.part8.internal.example1.AccountRepository;
import java.util.List;

public class Example1 {

  public static void main(String[] args) {
    bad();
    good();
  }

  private static void bad() {
    Account account1 = new Account();
    account1.addNew();
    account1.setName("Name");
    account1.save();
// загрузка объекта по Id
    Account account2 = Account.loadByPrimaryKey(1);
// загрузка связной коллекции при обращении к свойству объекта
    List<Role> list = account2.getRoles();
  }

  private static void good() {
    AccountRepository accountRepository = new AccountRepository();
    // создание пользователя
    Account account1 = new Account();
    account1.setName("Name");
    accountRepository.save(account1);

// загрузка пользователя по Id
    Account account2 = accountRepository.getById(1);

// загрузка со связной коллекцией
    Account account3 = accountRepository.getByIdWithRoles(1);
  }
}
