package com.restaurant.orderservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;



@Builder
@Data
public class OrderItemDto {
    @JsonProperty("item_id")
    private Long itemId;
    private Long quantity;

    public OrderItemDto() {
    }

    public OrderItemDto(Long quantity, Long itemId) {
        this.quantity = quantity;
        this.itemId = itemId;
    }
}
