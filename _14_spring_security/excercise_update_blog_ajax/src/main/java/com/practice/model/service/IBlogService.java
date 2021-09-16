package com.practice.model.service;

import com.practice.model.bean.Blog;
import com.practice.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    //lam them:
    Optional<Blog> findById(Integer id);

    //----------------update: bai 12-------------------//
    Page<Blog> findAllPage(Pageable pageable);

    List<Blog> findByContentContaining(String keyword);

    List<Blog> findAll();

}
