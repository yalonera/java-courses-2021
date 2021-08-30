package by.part7.order.dto;

import java.util.List;
import java.util.Objects;

public class OrdersDto {

  private int id;
  private PaymentInfoDto paymentInfo;
  private CustomerDto customer;
  private List<OrderItemDto> orderItems;

  public OrdersDto() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public PaymentInfoDto getPaymentInfo() {
    return paymentInfo;
  }

  public void setPaymentInfo(PaymentInfoDto paymentInfo) {
    this.paymentInfo = paymentInfo;
  }

  public List<OrderItemDto> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItemDto> orderItems) {
    this.orderItems = orderItems;
  }

  public CustomerDto getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerDto customer) {
    this.customer = customer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrdersDto order = (OrdersDto) o;
    return id == order.id;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
