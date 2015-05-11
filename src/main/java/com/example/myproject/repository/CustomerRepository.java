package com.example.myproject.repository;

import com.example.myproject.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// repository za customere, koji zna kako obavit create read update delete nad tim domenskim objektom,
//takodjer moguce je definirat custom methode kao findByEmail, ili override-ati postojece
public interface CustomerRepository extends CrudRepository<Customer,Long>{

    List<Customer> findByEmail(@Param("email") String email);
}
