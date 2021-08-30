package by.part10.homework.model;

import java.math.BigDecimal;

public class OrderItemBuilder {

    private Product product;
    private Integer quantity = 1;
    private BigDecimal price;

    public OrderItemBuilder setProduct(Product product) {
        this.product = product;
        return this;
    }

    public OrderItemBuilder setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderItemBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public OrderItem build() {
        return new OrderItem(product, quantity, price);
    }

    public OrderItem coffee() {
        final Product product = new Product();
        product.setId(1L);
        product.setType(ProductType.COFFEE);
        product.setName("Black");
        return new OrderItem(product, quantity, price);
    }

    public OrderItem tea() {
        final Product product = new Product();
        product.setId(2L);
        product.setType(ProductType.TEA);
        product.setName("Green");
        return new OrderItem(product, quantity, price);
    }
}