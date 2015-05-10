package com.example.myproject.service;

import com.example.myproject.domain.Customer;
import com.example.myproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> getUserById(long id) {
        return Optional.ofNullable(customerRepository.findOne(id));
    }

//    @Override
//    public Optional<Customer> findAll() {
//        return customerRepository.findAll();
//}

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Boolean isEmailAvailable(String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        return customers.isEmpty();
    }

}
