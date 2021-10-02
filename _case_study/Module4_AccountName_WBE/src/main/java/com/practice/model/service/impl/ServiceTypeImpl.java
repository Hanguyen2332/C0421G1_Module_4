package com.practice.model.service.impl;
import com.practice.model.entity.ServiceType;
import com.practice.model.repository.ServiceTypeRepository;
import com.practice.model.service.IServiceType;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service
public class ServiceTypeImpl implements IServiceType {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
