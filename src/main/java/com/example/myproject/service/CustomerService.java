package com.example.myproject.service;

import com.example.myproject.domain.Customer;

public interface CustomerService {

    boolean isEmailAvailable(String email);
    long count();

    Customer create(Customer customer);

}
