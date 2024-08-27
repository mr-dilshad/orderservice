package com.restaurant.orderservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "order-items")
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int quantity;

    public BigDecimal getTotalPrice() {
        return item.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    // Constructors, Getters, Setters

    public OrderItem() {}

    @Builder
    public OrderItem(Item item, int quantity, Order order) {
        this.item = item;
        this.quantity = quantity;
        this.order = order;
    }

    public OrderItem(com.restaurant.orderservice.model.OrderItemDto orderItemDto){
        return OrderItem.builder()
                .item()
                .quantity()
                .
    }
}