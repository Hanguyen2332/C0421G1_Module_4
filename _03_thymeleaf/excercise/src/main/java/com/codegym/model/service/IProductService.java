package com.codegym.model.service;

import com.codegym.model.bean.Product;

import java.util.List;


public interface IProductService {

        void create(Product product);

        List<Product> findAll();


        void update(Product product, Integer id);

        void delete(Integer id);

        List<Product> findByName(String name);

        //HÀM BỔ TRỢ:
        Product findById(Integer id);

        Integer idAutoIncrement(int mapSize);

}
