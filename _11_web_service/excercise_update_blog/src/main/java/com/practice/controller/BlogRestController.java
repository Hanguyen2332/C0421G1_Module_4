package com.practice.controller;

import com.practice.model.bean.Blog;
import com.practice.model.bean.Category;
import com.practice.model.service.IBlogService;
import com.practice.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/blog/api")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    //Xem danh sach category
    @GetMapping("/category")
    public ResponseEntity<List<Category>> showListCategory() {
        List<Category> categoryList = iCategoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);

    }

    //xem danh sách các bài viết
    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> showListBlog() {
        List<Blog> blogList = iBlogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    //Xem danh sách các bài viết của một category
        @GetMapping("/search-blog/category-id/{id}")
        public ResponseEntity<List<Blog>> findBlogByCategoryId(@PathVariable Integer id) {
            List<Blog> blogList = iBlogService.findByCategoryId(id);
            if (blogList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(blogList,HttpStatus.OK);
        }
        //Xem chi tiết một bài viết
        @GetMapping("/view-blog/{id}")
        public ResponseEntity<Blog> viewDetailBlog(@PathVariable Integer id) {
            Optional<Blog> blogOptional = iBlogService.findById(id);
            return blogOptional.map(blog -> new ResponseEntity<>(blog, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
}
