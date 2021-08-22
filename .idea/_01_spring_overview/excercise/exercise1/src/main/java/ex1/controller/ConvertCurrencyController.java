package ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertCurrencyController {
    //hien thi form convert:
    @GetMapping(value = "/converter")
    public String convertCurrencyForm() {
        //hien thi form (jsp)
        return "index";
    }
//    Tinh toan
    @RequestMapping(value = "/converter", method = RequestMethod.POST)
    public ModelAndView convertCurrency(@RequestParam("amount") long amount,
                                @RequestParam("rate") double rate) {
        //khoi tao ModelAndView
        ModelAndView mav = new ModelAndView("index");
        double vnd = rate*amount;
        //set gia tri --> gui model (data) --> view
        mav.addObject("vnd",vnd);
        mav.addObject("amount",amount);
        mav.addObject("rate",rate);
        return mav;
    }
}
