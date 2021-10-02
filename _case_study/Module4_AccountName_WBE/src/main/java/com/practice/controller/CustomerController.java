package com.practice.controller;

import com.practice.model.dto.CustomerDto;
import com.practice.model.entity.Customer;
import com.practice.model.service.ICusTypeService;
import com.practice.model.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICusTypeService iCusTypeService;

    //findAll - cach Phut:
    @GetMapping
    public ModelAndView showList(@RequestParam(name = "name",required = false) String name,
                                 @RequestParam(name = "cusTypeId",required = false) Integer cusTypeId,
                                 @PageableDefault(value = 4,sort = {"name","day_of_birth"}, direction = Sort.Direction.ASC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("name", name);  //hien thi lai keyword
        modelAndView.addObject("cusTypeId", cusTypeId); //hien thi lai keyword
        modelAndView.addObject("cusTypeList", iCusTypeService.findAll()); //select-option - tìm kiếm
        modelAndView.addObject("customerList", iCustomerService.findByKeyword(name,cusTypeId,pageable));  //gọi hàm

        return modelAndView;
    }

//    @GetMapping
//    public ModelAndView showList(@PageableDefault(value = 5,sort = {"name","dayOfBirth"}, direction = Sort.Direction.ASC) Pageable pageable) {
//        ModelAndView modelAndView = new ModelAndView("customer/list");
//        modelAndView.addObject("cusTypeList", iCusTypeService.findAll()); //select-option
//        modelAndView.addObject("customerList", iCustomerService.findAllPage(pageable));
////        modelAndView.addObject("customerList", iCustomerService.findAllPage(pageable));
//
//        return modelAndView;
//    }
//
//    //find-keyword
//    @GetMapping ("/find-keyword")
//    public ModelAndView showList(@PageableDefault(value = 4) Pageable pageable,
//                                 @RequestParam("name") String name,
//                                 @RequestParam("cusType") String cusType
//                                ) {
//        ModelAndView mav = new ModelAndView("customer/list");
//        mav.addObject("name", name);  //Chua search dc theo dividionName
//        mav.addObject("cusType", cusType);  //Chua search dc theo dividionName
//        mav.addObject("cusTypeList", iCusTypeService.findAll()); //select-option
//        //gọi hàm --> response
//        mav.addObject("customerList", iCustomerService.findByKeyword(name,cusType,pageable));
//        return mav;
//    }

    //view
    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id, Model model) {
        Optional<Customer> customerOpt = iCustomerService.findById(id);
        if (!customerOpt.isPresent()) {
            return "error";
        }
        //copy Customer --> CustomerDto
        Customer customer = customerOpt.get();
        //gender-->view
        model.addAttribute("customer",customer);
        return "customer/view";
    }

    //EDIT
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        Customer customer = iCustomerService.findById(id).get();
        //copy Customer --> CustomerDto
        CustomerDto cusDtoObj = new CustomerDto();
        BeanUtils.copyProperties(customer, cusDtoObj);
        //gender-->view
        addData(cusDtoObj, model);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@Validated @ModelAttribute("cusDtoObj") CustomerDto cusDtoObj,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        //Note: không cần check optional (vì không dùng @PathVariable)
        new CustomerDto().validate(cusDtoObj, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            addData(cusDtoObj, model);
            return "customer/edit";
        }
        callSaveFunction(cusDtoObj, redirectAttributes);
        return "redirect:/customer";
    }

    //create customer:
    @GetMapping("/create")
    public ModelAndView createForm(ModelAndView modelAndView) {
        modelAndView.setViewName("customer/create");
        modelAndView.addObject("cusTypeList", iCusTypeService.findAll()); //select-option
        modelAndView.addObject("cusDtoObj", new CustomerDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createCustomer(@Validated @ModelAttribute("cusDtoObj") CustomerDto cusDtoObj,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {

        new CustomerDto().validate(cusDtoObj, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            addData(cusDtoObj, model);
            return "customer/create";
        }
        callSaveFunction(cusDtoObj, redirectAttributes);
        return "redirect:/customer";
    }

    //delete
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        iCustomerService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete customer successfully!");
        return "redirect:/customer";
    }

    //Ham common: save
    public void callSaveFunction(CustomerDto cusDtoObj, RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(cusDtoObj, customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Action has been completed Successfully!");
    }

    //addData data - save/edit:
    public void addData(CustomerDto cusDtoObj,
                        Model model) {
        model.addAttribute("cusTypeList", iCusTypeService.findAll()); //select-option
        model.addAttribute("cusDtoObj", cusDtoObj);
    }
}
