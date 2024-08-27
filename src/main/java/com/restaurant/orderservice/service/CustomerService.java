package com.restaurant.orderservice.service;

import com.restaurant.orderservice.model.Customer;
import com.restaurant.orderservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(String firstName, String lastName, String email, String phoneNumber){
        Customer customer = Customer
                .builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();

        return customerRepository.save(customer);
    }
}
