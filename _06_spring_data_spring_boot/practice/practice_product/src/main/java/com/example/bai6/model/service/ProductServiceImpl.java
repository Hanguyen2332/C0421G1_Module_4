package com.example.bai6.model.service;

import com.example.bai6.model.bean.Product;
import com.example.bai6.model.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductRepo iProductRepo;

    @Override
    public List<Product> findAll() {
        return iProductRepo.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepo.save(product);
    }

    @Override
    public void delete(int id) {
        iProductRepo.deleteById(id);

    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepo.findByName(name);
    }

    @Override
    public Optional<Product> viewProduct(int id) {
        return iProductRepo.findById(id);
    }






    @Override
    public Product viewP(int id) {
        return iProductRepo.findById(id).get();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepo.findAll(pageable);
    }

//    @Override
//    public List<Product> findByNameMore(String name, double price1, double price2) {
//        return iProductRepo.
//    }


}
