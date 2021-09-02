package com.example.bai6.model.service;


import com.example.bai6.model.bean.Customer;
import com.example.bai6.model.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService<Customer> {

    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.delete(customerRepository.findById(id).get());
    }

    @Override
    public void saveBySp(String a, String b) {
        customerRepository.saveBySp(a,b);
    }
}
