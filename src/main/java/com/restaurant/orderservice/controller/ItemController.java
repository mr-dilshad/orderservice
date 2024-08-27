package com.restaurant.orderservice.controller;

import com.restaurant.orderservice.model.Item;
import com.restaurant.orderservice.dto.CreateItemDto;
import com.restaurant.orderservice.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody CreateItemDto item){
        Item createdItem = itemService.createItem(item.getProductName(), item.getPrice());

        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }
}
