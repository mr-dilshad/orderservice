package com.restaurant.orderservice.exception;

public class OrderCannotBeCreatedException extends RuntimeException {
    public OrderCannotBeCreatedException(String message){
        super(message);
    }
}
