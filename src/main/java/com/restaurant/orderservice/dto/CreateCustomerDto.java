package com.restaurant.orderservice.dto;

import lombok.Getter;

@Getter
public class CreateCustomerDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
