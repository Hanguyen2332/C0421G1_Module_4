package com.practice.controller;

import com.practice.model.bean.Blog;
import com.practice.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"", "blog"})
public class BlogController {

    @Autowired
    private IBlogService iBlogService;
//    private IBlogService iBlogService = new BlogServiceImpl();

    @GetMapping("")
    public ModelAndView findAll() {
        return new ModelAndView("index","blogList",iBlogService.findAll());
    }
//
    @GetMapping("/create")
    public ModelAndView saveBlogForm() {
        return new ModelAndView("create","blogObj",new Blog());
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("message","Create Successfully!!");

        return "redirect:/";
    }
//
    @GetMapping("/view/{id}")
    public ModelAndView findById(@PathVariable Integer id) {
         Blog blog = iBlogService.findById(id).get();
        return new ModelAndView("detail","blogObj",blog);
    }
//
    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id).get();
        return new ModelAndView("edit","blogObj",blog);
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("message","Edit Successfully!!");
        return "redirect:/";
    }



    @GetMapping("/delete/{id}")
    public String deleteBlogForm(@PathVariable Integer id, Model model) {
        Blog blog = iBlogService.findById(id).get();
        model.addAttribute("blogObj",blog);
        return "delete";
//        iBlogService.deleteById(id);

    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.deleteById(blog.getId());
        redirectAttributes.addFlashAttribute("message","Delete Successfully!!");
        return "redirect:/";
    }
}
