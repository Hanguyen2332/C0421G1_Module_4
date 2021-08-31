package com.practice.model.service;

import com.practice.model.bean.Blog;
import java.util.List;
import java.util.Optional;

public interface IBlogService {

void saveBlog(Blog blog); //edit + create;

//void editBlog(Blog blog); //theo id

List<Blog> findAll();

Optional<Blog> findById(Integer id);

void deleteById(Integer id);
}
