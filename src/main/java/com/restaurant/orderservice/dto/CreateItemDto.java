package com.restaurant.orderservice.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CreateItemDto {
    private String productName;
    private BigDecimal price;
}
