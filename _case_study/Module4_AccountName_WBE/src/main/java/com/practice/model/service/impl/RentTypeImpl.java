package com.practice.model.service.impl;
import com.practice.model.entity.RentType;
import com.practice.model.repository.RentTypeRepository;
import com.practice.model.service.IRentType;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class RentTypeImpl implements IRentType {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
