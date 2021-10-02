package com.practice.model.service.impl;

import com.practice.model.repository.ServiceRepository;
import com.practice.model.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements IService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<com.practice.model.entity.Service> findAll() {
        return serviceRepository.findAllHouSeAndVilla();
    }

    @Override
    public Page<com.practice.model.entity.Service> findAllPage(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public void save(com.practice.model.entity.Service object) {
        serviceRepository.save(object);

    }

    @Override
    public void delete(Integer id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Optional<com.practice.model.entity.Service> findById(Integer id) {
        return serviceRepository.findById(id);
    }
}
