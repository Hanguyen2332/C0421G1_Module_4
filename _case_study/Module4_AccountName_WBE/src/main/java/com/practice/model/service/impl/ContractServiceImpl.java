package com.practice.model.service.impl;

import com.practice.model.entity.Contract;
import com.practice.model.repository.ContractRepository;
import com.practice.model.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Contract save(Contract object) {
        return contractRepository.save(object);
    }

    @Override
    public Page<Contract> findNowCustomerPage(Pageable pageable) {
        return contractRepository.findNowCustomerPage(pageable);
    }
}
