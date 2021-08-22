package ex1.controller;

import ex1.model.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertController {
    @Autowired
    IConvertService iConvertService;

    //hien thi form
    @GetMapping("/converter")
    public String convert() {
        return "index";
    }

    //Tinh toan
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

