package com.restaurant.orderservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name= "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private BigDecimal price;
    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems;

    // Constructors, Getters, Setters

    public Item() {
    }

    @Builder
    public Item(String productName, BigDecimal price) {
        this.productName = productName;
        this.price = price;
    }
}
