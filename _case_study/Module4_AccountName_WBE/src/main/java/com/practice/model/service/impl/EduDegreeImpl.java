package com.practice.model.service.impl;
import com.practice.model.entity.employee.EducationDegree;
import com.practice.model.repository.IEduDegreeRepository;
import com.practice.model.service.IEduDegree;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class EduDegreeImpl implements IEduDegree {
    @Autowired
    private IEduDegreeRepository iEduDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return iEduDegreeRepository.findAll();
    }
}
