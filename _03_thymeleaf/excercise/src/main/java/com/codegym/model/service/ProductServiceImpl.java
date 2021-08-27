package com.codegym.model.service;

import com.codegym.model.bean.Product;
import com.codegym.model.repository.IProductRepos;
import com.codegym.model.repository.ProductReposImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepos iProductRepos;
//    private final IProductRepos iProductRepos = new ProductReposImpl();

    @Override
    public void create(Product product) {
        iProductRepos.create(product);
    }

    @Override
    public List<Product> findAll() {
        return iProductRepos.findAll();
    }

    @Override
    public void update(Product product, Integer id) {
        iProductRepos.update(product, id);
    }

    @Override
    public void delete(Integer id) {
        iProductRepos.delete(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepos.findByName(name);
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepos.findById(id);
    }

    @Override
    public Integer idAutoIncrement(int mapSize) {
        return iProductRepos.idAutoIncrement(mapSize);
    }
}
