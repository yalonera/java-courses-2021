package by.part7.order.model;

import reactor.core.publisher.Mono;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "payment_order_item")
@Entity
public class OrderItem {

  public OrderItem() {
  }

  @Id
  @GeneratedValue
  private int id;
  @Column(name = "product_id")
  private int productId;
  private Integer quantity;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public int getProductId() {
    return productId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
