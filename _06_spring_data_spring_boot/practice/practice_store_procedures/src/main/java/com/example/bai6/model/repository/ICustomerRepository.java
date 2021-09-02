package com.example.bai6.model.repository;

import com.example.bai6.model.bean.Customer;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {


    @Query(value = "{call Insert_Customer(:firstName,:lastName)}", nativeQuery = true)
    void saveBySp(@Param("firstName") String firstName, @Param("lastName") String lastName);
}


