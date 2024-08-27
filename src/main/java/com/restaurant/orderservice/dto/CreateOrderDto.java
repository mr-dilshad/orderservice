package com.restaurant.orderservice.dto;

import com.restaurant.orderservice.model.OrderItem;
import com.restaurant.orderservice.model.OrderItemDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateOrderDto {
    private Long customerId;
    private List<OrderItemDto> orderItems;
}
