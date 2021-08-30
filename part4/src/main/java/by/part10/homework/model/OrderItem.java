package by.part10.homework.model;

import java.math.BigDecimal;

public class OrderItem {

    private final Product product;
    private final Integer quantity;
    private final BigDecimal price;

    public OrderItem(Product product, Integer quantity, BigDecimal price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }
}
