package com.practice.model.service;

import com.practice.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findByKeyword(String name, Integer cusTypeId,Pageable pageable);

    List<Customer> findAll();

    Page<Customer> findAllPage(Pageable pageable);

    void save(Customer object);

    void delete(Integer id);

    Optional<Customer> findById(Integer id);
}
