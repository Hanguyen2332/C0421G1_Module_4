package com.practice.model.service.impl;

import com.practice.model.entity.employee.Employee;
import com.practice.model.repository.EmployeeRepository;
import com.practice.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAllPage(String keyword, Pageable pageable) {
        if (keyword == null) {
            return employeeRepository.findAll(pageable);
        }
        return employeeRepository.findAll(keyword, pageable);
    }

    @Override
    public void save(Employee object) {
        employeeRepository.save(object);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById( id);
    }

//    @Override
//    public List<Employee> findMultiField(String name) {
//        return employeeRepository.findByNameContains(name);
//    }

//    @Override
//    public List<Employee> findMultiField(String name, Date birthday, String divisionName) {
//        return employeeRepository.findByNameContainsOrDayOfBirthOrDivisionName(name,birthday,divisionName);
//    }

}
