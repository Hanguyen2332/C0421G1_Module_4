package com.practice.model.service;

import com.practice.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
public interface IEmployeeService {

    List<Employee> findAll();

    Page<Employee> findAllPage(String keyword,Pageable pageable);

    void save(Employee object);

    void delete(Integer id);

    Optional<Employee> findById(Integer id);

    //find
//    List<Employee> findMultiField(String name);

//    List<Employee> findMultiField(String name, Date birthday, String divisionName);

}
