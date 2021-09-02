package com.example.bai6.model.repository;


import com.example.bai6.model.bean.Product;
import org.springframework.data.domain.Page;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface IProductRepo extends JpaRepository<Product, Integer> {

    List<Product>findByName(String name);

//  Page<Product> findAll(Pa);








}
