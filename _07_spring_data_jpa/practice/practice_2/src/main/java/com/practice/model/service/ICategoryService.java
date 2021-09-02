package com.practice.model.service;

import com.practice.model.bean.Blog;
import com.practice.model.bean.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    void saveCategory(Category object); //

    void deleteCategory(Integer id);

    Optional<Category> findById(Integer id);
}
