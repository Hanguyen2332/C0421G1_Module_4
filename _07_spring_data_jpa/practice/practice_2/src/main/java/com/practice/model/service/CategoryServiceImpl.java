package com.practice.model.service;

import com.practice.model.bean.Blog;
import com.practice.model.bean.Category;
import com.practice.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {

        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(Category object) {  //create+edit
        categoryRepository.save(object);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }
}
