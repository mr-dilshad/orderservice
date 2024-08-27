package com.restaurant.orderservice.service;

import com.restaurant.orderservice.exception.OrderCannotBeCreatedException;
import com.restaurant.orderservice.model.*;
import com.restaurant.orderservice.model.OrderItemDto;
import com.restaurant.orderservice.repository.CustomerRepository;
import com.restaurant.orderservice.repository.ItemRepository;
import com.restaurant.orderservice.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;

    private final ItemService itemService;

//    private final OrderItemMapper orderItemMapper;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, OrderRepository orderItemRepository, ItemRepository itemRepository, ItemService itemService) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.itemService = itemService;
//        this.orderItemMapper = orderItemMapper;
    }

    @Transactional
    public Order createOrder(Long customerId, List<OrderItemDto> orderItemsDto){

        Order order = null;
        try {
            // Fetch a customer
            Customer customer = customerRepository.getReferenceById(customerId);


            //Calculating total Amount
            BigDecimal totalAmount = getTotalAmount(orderItemsDto);

            // Mapping orderItemDtos to OrderItems entity
//            List<OrderItem> orderItems = orderItemsDto.stream().map(orderItemMapper::dtoToModel).toList();

            // Create an order
            order = Order
                    .builder()
                            .orderDate(LocalDateTime.now())
                                    .customer(customer)
                                            .orderItems(orderItems)
                                                    .status(OrderStatus.NEW)
                                                            .totalAmount(totalAmount)
                                                                    .build();
        }catch (EntityNotFoundException exception){
            LOGGER.error("Exception occured while creating the order: {}", exception.getMessage());
            throw new OrderCannotBeCreatedException("Some error occured while creating the order");
        }

        assert order != null;
        // Save the order (and cascade to items)
        return orderRepository.save(order);
    }


    private BigDecimal getTotalAmount(List<OrderItemDto> items) {
        return items.stream()
                .map(item -> itemService.priceForGivenQuantiy(item.getItemId(), item.getQuantity()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
