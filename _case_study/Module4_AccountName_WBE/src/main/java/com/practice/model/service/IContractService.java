package com.practice.model.service;

import com.practice.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {

    Contract save (Contract object);

//    Optional<Contract> findById(Integer id);

    Page<Contract> findNowCustomerPage(Pageable pageable);

}
