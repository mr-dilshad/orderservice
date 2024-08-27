package com.restaurant.orderservice.controller;

import com.restaurant.orderservice.dto.CreateOrderDto;
import com.restaurant.orderservice.model.Order;
import com.restaurant.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderDto order){
        Order createdOrder = orderService.createOrder(order.getCustomerId(), order.getOrderItems());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }
}
