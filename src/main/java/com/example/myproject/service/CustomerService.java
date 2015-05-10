package com.example.myproject.service;

import com.example.myproject.domain.Customer;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Collection;

public interface CustomerService {

    Optional<Customer> getUserById(long id);

    Boolean isEmailAvailable(String email);

//    Optional<Customer> findAll();
//
    long count();

    Customer create(Customer customer);

}
