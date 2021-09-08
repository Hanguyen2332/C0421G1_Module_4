package com.practice.model.service;

import com.practice.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Optional<Product> finById(Long id);

    List<Product> findAll();
}
