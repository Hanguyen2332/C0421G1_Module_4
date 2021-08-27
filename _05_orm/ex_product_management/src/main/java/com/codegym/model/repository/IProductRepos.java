package com.codegym.model.repository;

import com.codegym.model.bean.Product;

import java.util.List;
import java.util.Map;

public interface IProductRepos {
    void save(Product product);

    List<Product> findAll();

    ////    void update(Product product, Integer id);
    void delete(Integer id);

    Product findByName(String name);

    //HÀM BỔ TRỢ:
    Product findById(Integer id);


}
