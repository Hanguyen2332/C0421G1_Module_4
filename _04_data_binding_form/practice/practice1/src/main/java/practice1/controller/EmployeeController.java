package practice1.controller;


import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import practice1.model.bean.Employee;
import practice1.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    //hien thi form
    @GetMapping({"", "/list"})
    public ModelAndView showList() {
        return new ModelAndView("index","employeeList",iEmployeeService.showList());
    }
    @GetMapping({"/create"})
    public ModelAndView createForm() {
        Employee employee = new Employee();
        return new ModelAndView("create","newEmployee",employee);
    }
    //Save Condiment
    @PostMapping(value = "/create")
    public String convertCurrency(@ModelAttribute Employee newEmployee,  //uu diem: KHONG cần get ra từng thuộc tính của input --> set cho thuộc tính của object
                                  RedirectAttributes redirectAttributes) {
        //goi ham
        iEmployeeService.create(newEmployee);
        //Hien thong bao:
        redirectAttributes.addFlashAttribute("message","Create Successfully!");
        //chuye huong ve trang list:
        return "redirect:/list";
    }
}

