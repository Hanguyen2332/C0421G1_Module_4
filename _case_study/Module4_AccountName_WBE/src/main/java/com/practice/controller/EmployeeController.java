package com.practice.controller;

import com.practice.model.dto.EmployeeDto;
import com.practice.model.entity.employee.Employee;
import com.practice.model.service.IDivision;
import com.practice.model.service.IEduDegree;
import com.practice.model.service.IEmployeeService;
import com.practice.model.service.IPosition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IDivision iDivision;

    @Autowired
    private IPosition iPosition;

    @Autowired
    private IEduDegree iEduDegree;

    @GetMapping
    public ModelAndView showList(@PageableDefault(value = 4) Pageable pageable) {
        ModelAndView mav = new ModelAndView("employee/list");
        String keyword = null;
        mav.addObject("employeeList", iEmployeeService.findAllPage(keyword,pageable));
        return mav;
    }

    @GetMapping ("/find")
    public ModelAndView showList(@PageableDefault(value = 4) Pageable pageable, @RequestParam("keyword") String keyword) {
        ModelAndView mav = new ModelAndView("employee/list");
        mav.addObject("keyword", keyword);  //Chua search dc theo dividionName
        mav.addObject("employeeList", iEmployeeService.findAllPage(keyword,pageable));
        return mav;
    }


    //EDIT
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        Employee employee = iEmployeeService.findById(id).get();
        //copy
        EmployeeDto empDtoObj  = new EmployeeDto();
        BeanUtils.copyProperties(employee, empDtoObj);
        //gender-->view
        addData(empDtoObj, model);
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String editEmployee(@Validated @ModelAttribute("empDtoObj") EmployeeDto empDtoObj,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        //Note: không cần check optional (vì không dùng @PathVariable)
        new EmployeeDto().validate(empDtoObj, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            addData(empDtoObj, model);
            return "employee/edit";
        }
        callSaveFunction(empDtoObj, redirectAttributes);
        return "redirect:/employee";
    }

    //create employee:
    @GetMapping("/create")
    public ModelAndView createForm(ModelAndView modelAndView) {
        modelAndView.setViewName("employee/create");
        modelAndView.addObject("divisionList", iDivision.findAll()); //select-option
        modelAndView.addObject("positionList", iPosition.findAll()); //select-option
        modelAndView.addObject("eduDegreeList", iEduDegree.findAll()); //select-option

        modelAndView.addObject("empDtoObj", new EmployeeDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createEmployee(@Validated @ModelAttribute("empDtoObj") EmployeeDto empDtoObj,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {

        new EmployeeDto().validate(empDtoObj, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            addData(empDtoObj, model);
            return "employee/create";
        }
        callSaveFunction(empDtoObj, redirectAttributes);
        return "redirect:/employee";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        iEmployeeService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete employee successfully!");
        return "redirect:/employee";
    }

    //Ham common: save
    public void callSaveFunction(EmployeeDto empDtoObj, RedirectAttributes redirectAttributes) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(empDtoObj, employee);
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Action has been completed Successfully!");
    }

    //addData data - save/edit:  ---> response--> view (neu co loi validate)
    public void addData(EmployeeDto empDtoObj,
                        Model model) {
        model.addAttribute("divisionList", iDivision.findAll());
        model.addAttribute("positionList", iPosition.findAll()); //select-option
        model.addAttribute("eduDegreeList", iEduDegree.findAll()); //select-option

        model.addAttribute("empDtoObj", empDtoObj);
    }
}
