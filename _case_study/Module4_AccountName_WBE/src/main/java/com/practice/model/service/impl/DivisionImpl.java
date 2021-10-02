package com.practice.model.service.impl;


import com.practice.model.entity.employee.Division;
import com.practice.model.repository.IDivisionRepository;
import com.practice.model.service.IDivision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionImpl implements IDivision {
    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
