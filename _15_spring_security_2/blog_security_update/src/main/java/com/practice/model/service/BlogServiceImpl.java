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

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> findByTitleContaining(String title) {
        return blogRepository.findByTitleContaining(title);
    }

    @Override
    public List<Blog> findByTitleIsContaining(String title) {
        return blogRepository.findByTitleIsContaining(title);
    }

    @Override
    public List<Blog> findByTitleContains(String title) {
        return blogRepository.findByTitleContains(title);
    }

    @Override
    public List<Blog> findByTitleLike(String title) {
        return blogRepository.findByTitleLike(title);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> paging(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findByCategoryId(Integer id) {
        return blogRepository.findByCategoryId(id);
    }

//    @Override
//    public List<Blog> findByCategory_Id(Integer id) {
//        return blogRepository.findByCategory_Id(id);
//    }

//    @Override
//    public List<Blog> findByCategory(Category object) {
//        return blogRepository.findByCategory(object);
//    }

}
