package com.practice.controller;

import com.practice.model.bean.Blog;
import com.practice.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping({"/list"})
    public ModelAndView findAll() {
        List<Blog> blogList = iBlogService.findAll();  //PageRequest.of(a,b): a = page thứ..., b= số phần tử của page
return new ModelAndView("index", "blogList",blogList);
    }
}
