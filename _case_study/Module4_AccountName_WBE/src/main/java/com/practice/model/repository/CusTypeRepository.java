package com.practice.model.repository;

import com.practice.model.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CusTypeRepository extends JpaRepository<CustomerType, Integer> {
}
