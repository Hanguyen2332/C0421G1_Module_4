package com.practice.model.repository;

import com.practice.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContractRepository extends JpaRepository<Contract,Integer> {

    @Query(value = "SELECT c FROM Contract c WHERE c.startDate <= current_date AND c.endDate >=current_date", nativeQuery = true)
    Page<Contract> findNowCustomerPage (Pageable pageable);
}
