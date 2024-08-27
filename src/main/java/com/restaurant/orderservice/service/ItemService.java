package com.restaurant.orderservice.service;

import com.restaurant.orderservice.model.Item;
import com.restaurant.orderservice.model.OrderItem;
import com.restaurant.orderservice.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(String productName, BigDecimal price){
        Item item = Item.builder()
                .productName(productName)
                .price(price)
                .build();
        return itemRepository.save(item);
    }

    public BigDecimal priceForGivenQuantiy(Long itemId, Long quantity){
        Item item = itemRepository.getReferenceById(itemId);
        return item.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public Item getItemById(Long id){
        return itemRepository.getReferenceById(id);
    }
}
