package by.part8;

import java.util.List;

public class Example5 {

  public abstract class AbstractEntity {

    private Long id;
  }

  public class AccountEntity extends AbstractEntity {

    private String login;
    private List<RoleEntity> roles;
  }

  public class RoleEntity extends AbstractEntity {

    private String name;
  }

  public class Repository {

    public void save(AbstractEntity entity) {
      if (entity instanceof AccountEntity) {
// специфические действия для AccountEntity
      }
      if (entity instanceof RoleEntity) {
// специфические действия для RoleEntity
      }
    }
  }
}
