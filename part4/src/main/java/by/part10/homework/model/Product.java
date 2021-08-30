package by.part10.homework.model;

public class Product {

  private Long id;
  private String name;
  private ProductType type;
  public Product() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductType getType() {
    return type;
  }

  public void setType(ProductType type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Product #" + id + " (" + name + ")";
  }
}
