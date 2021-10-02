package com.practice.model.repository;

import com.practice.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query("select e From Employee e WHERE concat(e.id,e.name,e.division.name,e.email) LIKE %?1%")
    public Page<Employee> findAll(String keyword, Pageable pageable);

//    List<Employee> findByNameContainsOrDayOfBirthOrDivisionName(String name, Date birthday, String divisionName);

//    List<Employee> findByNameOrDayOfBirthOrDivisionName(String name, Date birthday, String divisionName);
}
