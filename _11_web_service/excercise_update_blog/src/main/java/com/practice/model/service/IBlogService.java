package com.practice.model.service;

import com.practice.model.bean.Blog;
import com.practice.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

void saveBlog(Blog blog); //edit + create;

//    List<Blog> findByTitleContaining(String title);
//
//    List<Blog> findByTitleIsContaining(String title);
//
//    List<Blog> findByTitleContains(String title);
//    List<Blog> findByTitleLike(String title);

//void editBlog(Blog blog); //theo id

List<Blog> findAll();

Optional<Blog> findById(Integer id);

void deleteById(Integer id);

Page<Blog> paging(Pageable pageable);

List<Blog>  findByCategoryId(Integer id);
}
