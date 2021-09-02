package com.practice.controller;

import com.practice.model.bean.Category;
import com.practice.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping({"","/category"})
@RequestMapping({"/category"})
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    //list
    @GetMapping("")
    public ModelAndView showList() {
        return new ModelAndView("category_list","categoryList",iCategoryService.findAll());
    }
    //create
    @GetMapping("/category_create")
    public ModelAndView createForm() {
        return new ModelAndView("category_create","categoryObj",new Category());
    }
    //create
    @PostMapping("/category_create")
    public String create(@ModelAttribute Category categoryObj, RedirectAttributes redirectAttributes) {
        iCategoryService.saveCategory(categoryObj);
        redirectAttributes.addFlashAttribute("message","Create Successfully!");
        return "redirect:/category/";
    }

    //edit
    @GetMapping("/category_edit/{id}")
    public ModelAndView editForm(@PathVariable Integer id) {
        Category category = iCategoryService.findById(id).get(); //hien infor Object can edit
        return new ModelAndView("category_edit","categoryObj",category);
    }
    //create
    @PostMapping("/category_edit")
    public String edit(@ModelAttribute Category categoryObj, RedirectAttributes redirectAttributes) {
        iCategoryService.saveCategory(categoryObj);
        redirectAttributes.addFlashAttribute("message","Edit Successfully!");
        return "redirect:/category/";
    }

    //delete
    @GetMapping("/category_delete/{id}")
    public ModelAndView deleteForm(@PathVariable Integer id) {
        Category category = iCategoryService.findById(id).get(); //hien infor Object can DELETE
        return new ModelAndView("category_delete","categoryObj",category);
    }
    //delete
    @PostMapping("/category_delete")
    public String delete(@ModelAttribute Category categoryObj, RedirectAttributes redirectAttributes) {
        iCategoryService.deleteCategory(categoryObj.getId());
        redirectAttributes.addFlashAttribute("message","Delete Successfully!");
        return "redirect:/category/";
    }
}
