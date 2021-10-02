package com.practice.model.service.impl;

import com.practice.model.entity.Customer;
import com.practice.model.repository.CustomerRepository;
import com.practice.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

//    @Override
//    public Page<Customer> findByKeyword(String name, String cusTypeName,Pageable pageable) {
//        String nameChar = name.trim();
//        String cusTypeNameChar = cusTypeName.trim();
//
//        if (nameChar.equals("") && !cusTypeNameChar.equals("")) {
//            return customerRepository.findAllByCustomerTypeTypeName(cusTypeName, pageable);
//        }else if (!nameChar.equals("") && cusTypeNameChar.equals("") ) {
//            return customerRepository.findByNameContains(name,pageable);
//        }else {
//            return customerRepository.findByNameContainsAndCustomerTypeTypeName(nameChar, cusTypeNameChar,pageable);
//        }
//    }

    //cach Phut:
    @Override
    public Page<Customer> findByKeyword(String name, Integer cusTypeId,Pageable pageable) {
//        String nameChar = name.trim();
//        String cusTypeNameChar = cusTypeName.trim();

        return customerRepository.findAll(name,cusTypeId,pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAllPage(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer object) {
        customerRepository.save(object);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }
}
