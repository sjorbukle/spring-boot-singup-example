package com.example.myproject.repository;

import com.example.myproject.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long>{

    List<Customer> findByEmail(@Param("email") String email);
}
