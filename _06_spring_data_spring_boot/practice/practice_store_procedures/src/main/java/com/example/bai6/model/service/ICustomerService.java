package com.example.bai6.model.service;

import java.util.List;

public interface ICustomerService<Customer> {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    void saveBySp(String a ,String b);

}