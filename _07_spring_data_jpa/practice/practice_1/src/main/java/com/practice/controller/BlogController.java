package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    @Autowired
    private ICategoryService iCategoryService;


    //UPDATE:
    //1. paging + sorting (by date)
    @GetMapping({"", "/list"})
    public ModelAndView findAll(
            @PageableDefault(value = 2, sort = "createDate", direction = Sort.Direction.ASC) Pageable pageable) {
        return new ModelAndView("index", "blogList", iBlogService.paging(pageable));
    }

    //1. findByCategory (hiển thị bài viết theo danh mục)
    @GetMapping("/search_by_category")
    public ModelAndView searchByCategoryForm() {
        ModelAndView mav = new ModelAndView("find_by_category");
        mav.addObject("categoryList", iCategoryService.findAll());//select-option
        mav.addObject("category", new Category());

        return mav;
    }

    @PostMapping("/search_by_category")
    public ModelAndView searchByCategory(@ModelAttribute Category category) {
        //goi ham findByCategory:
        ModelAndView mav = new ModelAndView("find_by_category");  //đẩy kg về trang cũ:
        mav.addObject("blogList", iBlogService.findByCategoryId(category.getId()));
        mav.addObject("categoryList", iCategoryService.findAll()); //hien thi lai select-option
        mav.addObject("category", category);  //hiển thị lại lựa chọn

        return mav;
    }

    //create:
    @GetMapping("/create")
    public ModelAndView saveBlogForm() {
        ModelAndView mav = new ModelAndView("create");
        mav.addObject("categoryList", iCategoryService.findAll());
        mav.addObject("blogObj", new Blog());
        return mav;
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Create Successfully!!");

        return "redirect:/";
    }

    //
    @GetMapping("/view/{id}")
    public ModelAndView findById(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id).get();
        return new ModelAndView("detail", "blogObj", blog);
    }

    //
    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("edit");
        Blog blog = iBlogService.findById(id).get();  //hiên thi infor blog
        mav.addObject("blogObj", blog);
        mav.addObject("categoryList", iCategoryService.findAll());  //gửi list category --> dropdown

        return mav;
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Edit Successfully!!");
        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String deleteBlogForm(@PathVariable Integer id, Model model) {
        Blog blog = iBlogService.findById(id).get();
        model.addAttribute("blogObj", blog);
        return "delete";
//        iBlogService.deleteById(id);

    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.deleteById(blog.getId());
        redirectAttributes.addFlashAttribute("message", "Delete Successfully!!");
        return "redirect:/";
    }
}
