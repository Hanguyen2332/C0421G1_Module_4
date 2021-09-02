package com.codegym.controller;

import com.codegym.model.bean.Customer;
import com.codegym.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@RequestMapping(value = "/customer")
@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping(value = {"/", "/list"})
    public ModelAndView goListStudent() {
        ModelAndView modelAndView = new ModelAndView("list_customer");
        List<Customer> customerList = customerService.findAll();
        modelAndView.addObject("customerList", customerList);   // list.html: customers --> customerList

        return modelAndView;
    }

    @GetMapping(value = "/create")
    public String goCreateNewStudent(Model model) {
        model.addAttribute("customer", new Customer());
        return "create_customer";
    }

    @PostMapping(value = "/create")
    public String createStudent(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Create new successfully!");

        return "redirect:/customer/list";
    }

    @GetMapping(value = "/detail")
    public String goDetailStudent(@RequestParam Integer idCustomer, Model model) {
        model.addAttribute("customer", customerService.findById(idCustomer));

        return "detail_customer";
    }

    @GetMapping(value = "/detail/{idCustomer}")
    public String goDetailStudentPV(@PathVariable Integer idCustomer, Model model) {
        model.addAttribute("customer", customerService.findById(idCustomer));

        return "detail_customer";
    }
}
