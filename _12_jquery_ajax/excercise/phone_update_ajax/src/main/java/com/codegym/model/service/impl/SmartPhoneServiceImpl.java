package com.codegym.model.service.impl;

import com.codegym.model.entity.SmartPhone;
import com.codegym.model.repository.ISmartPhoneRepository;
import com.codegym.model.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SmartPhoneServiceImpl implements ISmartPhoneService {

    @Autowired
    ISmartPhoneRepository smartPhoneRepository;
    @Override
    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }


    @Override
    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }
}