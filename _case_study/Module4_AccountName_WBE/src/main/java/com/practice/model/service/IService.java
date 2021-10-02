package com.practice.model.service;

import com.practice.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IService {

    List<Service> findAll();

    Page<Service> findAllPage(Pageable pageable);

    void save(Service object);

    void delete(Integer id);

    Optional<Service> findById(Integer id);

}
