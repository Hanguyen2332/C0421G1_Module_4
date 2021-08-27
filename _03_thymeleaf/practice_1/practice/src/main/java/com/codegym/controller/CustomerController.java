package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
//    @Autowired
//    private ICustomerService customerService;
    private final ICustomerService customerService = new CustomerService();

    @GetMapping("")
    public String index(Model model) {

        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }

    //
//
    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("/create_test", "customer", new Customer());
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer,
                       RedirectAttributes redirectAttribute) {
        customer.setId((int) Math.floor(Math.random() * 100));
        customerService.save(customer);
        redirectAttribute.addFlashAttribute("message", "Create new customer successfully!");
        return "redirect:/customer";
    }


    @GetMapping("{id}/edit")
    public ModelAndView editForm(@PathVariable int id) {
        return new ModelAndView("/edit_test", "customer", customerService.findById(id));
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Customer customer,
                       RedirectAttributes redirectAttributes) {

        customerService.update(customer.getId(), customer);
        redirectAttributes.addFlashAttribute("message", "Edit customer successfully!");
        return "redirect:/customer";
    }

    //delete:
    @GetMapping("{id}/delete")
    public ModelAndView deleteForm(@PathVariable int id) {
        return new ModelAndView("/delete_test", "customer", customerService.findById(id));
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Customer customer,
                         RedirectAttributes redirectAttributes) {
        customerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("message", "Delete customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}