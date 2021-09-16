package com.practice.model.service;

import com.practice.model.bean.Blog;
import com.practice.model.bean.Category;
import com.practice.model.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;
//lam them:
    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public Page<Blog> findAllPage(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    //----------------update: bai 12-------------------//
    @Override
    public List<Blog> findByContentContaining(String keyword) {
        return blogRepository.findByContentContaining(keyword);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }
}
