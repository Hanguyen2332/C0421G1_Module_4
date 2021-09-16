package com.practice.controller;

import com.practice.model.bean.Blog;
import com.practice.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/blog/api")
@CrossOrigin(origins = "http://localhost:63342")

public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    //lam them: tim theo id - modal
    @GetMapping("/find_by_id")
    public ResponseEntity<Blog> findById(@RequestParam Integer id) {
        Optional<Blog> blogOptional = iBlogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Blog blogObj = blogOptional.get();
        return new ResponseEntity<>(blogObj, HttpStatus.OK);
    }


    //--------------------------upate: bài 12------------------------------//
    //1. tìm blog theo keyword:
    @GetMapping("/find_by_keyword")
    public ResponseEntity<List<Blog>> findByKeyword(@RequestParam String keyword) {
        List<Blog> blogList = iBlogService.findByContentContaining(keyword);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    //2. phân trang:

//    @GetMapping({"", "/list"})
//    public ResponseEntity<Page<Blog>> findAll(@PageableDefault(value = 2) Pageable pageable) {
//        Page<Blog> blogList = iBlogService.findAllPage(pageable);  //PageRequest.of(a,b): a = page thứ..., b= số phần tử của page
//        if (blogList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }
    @GetMapping({"/list"})
    public ResponseEntity<Page<Blog>> findAll(@RequestParam int page) {
        Page<Blog> blogList = iBlogService.findAllPage(PageRequest.of(page, 2, Sort.by("createDate").descending()));  //PageRequest.of(a,b): a = page thứ..., b= số phần tử của page
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
