package com.practice.model.repository;


import com.practice.model.bean.Blog;
import com.practice.model.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {


    //    test:
    List<Blog> findByTitleContaining(String title);

    List<Blog> findByTitleIsContaining(String title);

    List<Blog> findByTitleContains(String title);
    List<Blog> findByTitleLike(String title);
//--------------//--------------------
    List<Blog> findByCategoryId(Integer id);

}
