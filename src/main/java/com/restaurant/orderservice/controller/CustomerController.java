package com.restaurant.orderservice.controller;

import com.restaurant.orderservice.dto.CreateCustomerDto;
import com.restaurant.orderservice.model.Customer;
import com.restaurant.orderservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CreateCustomerDto customerDto){
        Customer createdCustomer = customerService.createCustomer(customerDto.getFirstName(), customerDto.getLastName(), customerDto.getEmail(), customerDto.getPhoneNumber());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        return null;
    }
}
