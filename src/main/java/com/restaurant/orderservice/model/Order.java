package com.restaurant.orderservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    // Constructors, Getters, and Setters

    public Order() {}

    @Builder
    public Order(LocalDateTime orderDate, BigDecimal totalAmount, OrderStatus status, Customer customer, List<OrderItem> orderItems) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.customer = customer;
        this.orderItems = orderItems;
    }
}