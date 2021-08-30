package by.part8;

import by.part8.internal.Account;
import by.part8.internal.Product;

public class Example9 {

  public interface Specification {

    boolean isSuitable(Product realty, Account account);

    boolean isChanged(Product product);
  }

  public class ProductRepository {

    private Specification specification;

    public void save(Product product) {
      if (specification.isChanged(product)) {
        // do smth
      }
    }
  }

  public class ProductCalculator {

    private Specification specification;

    public void calculate(Product realty, Account account) {
      if (specification.isSuitable(realty, account)) {
        // do smth
      }
    }
  }
}
