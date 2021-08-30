package by.part8.internal;

import java.util.List;

public class Account {

  private List<Role> roles;
  private String name;

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addNew() {
    // make insert into database
  }

  public void save() {
    // make update into database
  }

  public static Account loadByPrimaryKey(int id) {
    // find by primary key
    return null;
  }
}
