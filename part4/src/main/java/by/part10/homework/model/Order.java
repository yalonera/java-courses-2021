package by.part10.homework.model;

import java.util.List;

public class Order {

  private Long orderId;
  private List<OrderItem> orderItems;
  public Order() {
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Order order = (Order) o;

    return orderId.equals(order.orderId);
  }

  @Override
  public int hashCode() {
    return orderId.hashCode();
  }
}
