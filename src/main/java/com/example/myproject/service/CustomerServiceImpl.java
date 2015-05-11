package com.example.myproject.service;

import com.example.myproject.domain.Customer;
import com.example.myproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// servis koji je zaaduzen za business logic za Customer domain object, implementira CustomerService interface
// i cesto bude vise razlicitih implementacija ovisno o kompleksnosti business logike
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean isEmailAvailable(String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        return customers.isEmpty();
    }

}
