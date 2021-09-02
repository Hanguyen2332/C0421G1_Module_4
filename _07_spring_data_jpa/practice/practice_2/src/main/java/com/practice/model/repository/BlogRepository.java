package com.practice.model.repository;


import com.practice.model.bean.Blog;
import com.practice.model.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

//    List<Blog> findByCategory(Category object);

//    List<Blog> findByCategory_Id(Integer id);

    List<Blog>  findByCategoryId(Integer id);

}
