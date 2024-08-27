//package com.restaurant.orderservice.mapper;
//
//
//import com.restaurant.orderservice.model.OrderItem;
//import com.restaurant.orderservice.model.OrderItemDto;
//import com.restaurant.orderservice.service.ItemService;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//
//@Mapper
//public class OrderItemMapper {
//
//    private final ItemService itemService;
//
//    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);
//
//    public OrderItemMapper(ItemService itemService) {
//        this.itemService = itemService;
//    }
//
//    public OrderItem dtoToModel(OrderItemDto orderItemDto){
//        return  OrderItem.builder()
//                .item(itemService.getItemById(orderItemDto.getItemId()))
//                .quantity(orderItemDto.getQuantity())
//                .build();
//    }
//
//    public OrderItemDto modelToDto(OrderItem orderItem){
//        return OrderItemDto.builder()
//                .itemId(orderItem.getId())
//                .quantity(orderItem.getQuantity())
//                .build();
//    }
//
//
//
//}
