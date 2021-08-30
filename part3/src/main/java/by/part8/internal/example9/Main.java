package by.part8.internal.example9;

import by.part8.internal.Account;
import by.part8.internal.Product;

public class Main {

  public class SpecificationImpl implements ChangeFieldDetector, Specification {

    @Override
    public boolean isChanged(Product product) {
      return false;
    }

    @Override
    public boolean isSuitable(Product realty, Account account) {
      return false;
    }
  }

  public class ProductRepository {

    private ChangeFieldDetector specification;

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
