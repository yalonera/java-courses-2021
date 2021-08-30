package by.part8.internal;

public class Product {

  private double price;

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public boolean isValid() {
    return price > 0;
  }

  public boolean isValid(boolean isAuto, boolean isAvia) {
    if (isAuto) {
      return price > 100000;
    }
    if (isAvia) {
      return price > 10000000;
    }
    return price > 0;
  }
}
