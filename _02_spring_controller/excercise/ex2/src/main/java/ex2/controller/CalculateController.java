package ex2.controller;


import ex2.model.service.ICalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CalculateController {
    @Autowired
    private ICalculationService iCalculationService;

    //hien thi form
    @GetMapping({"", "/calculate_form"})
    public String showCalculate() {
        return "index";
    }

    //Save Condiment
    @PostMapping(value = "/calculate")
    public ModelAndView convertCurrency(@RequestParam String operand,
                                        @RequestParam double a,
                                        @RequestParam double b) {
        ModelAndView mav =  new ModelAndView("index");
//        try {
//            double result = iCalculationService.calculate(operand,a,b);
//            mav.addObject("result",result);
//        }catch (MethodArgumentTypeMismatchException e) {
//            mav.addObject("message","Please enter NUMBER!");
//        }

        //tính toán:
        double result = iCalculationService.calculate(operand,a,b);
        mav.addObject("result",result);
        //gui lai so đã nhập:
        mav.addObject("a",a);
        mav.addObject("b",b);
        mav.addObject("operand",operand);

        return mav;
    }
}

