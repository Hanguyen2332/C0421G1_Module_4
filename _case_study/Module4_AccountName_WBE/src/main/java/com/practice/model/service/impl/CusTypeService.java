package com.practice.model.service.impl;

import com.practice.model.entity.CustomerType;
import com.practice.model.repository.CusTypeRepository;
import com.practice.model.service.ICusTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CusTypeService implements ICusTypeService {
    @Autowired
    private CusTypeRepository cusTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return cusTypeRepository.findAll();
    }
}
