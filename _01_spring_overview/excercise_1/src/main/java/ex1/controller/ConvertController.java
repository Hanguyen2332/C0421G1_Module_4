package ex1.controller;

import ex1.model.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
    @GetMapping("/converter") // localhost8080/furama
    public String convert() {
        return "index";
    }

    //Tinh toan
    @RequestMapping(value = "/converter", method = RequestMethod.POST)
    public ModelAndView convertCurrency(@RequestParam("amount") long amount,
                                        @RequestParam("rate") double rate,
                                        ModelAndView mav,

                                        Model model,
                                        ModelMap modelMap) {

        double vnd = iConvertService.convert(amount,rate);

//        //C1: ModelAndView

        mav.addObject("vnd",vnd);
        mav.addObject("amount",amount);
        mav.addObject("rate",rate);
        mav.setViewName("index");
        return mav;         //đối tượng ModelAndView (data+tên file jsp)

////        //C2: Model:
//        model.addAttribute("vnd",vnd);
//        model.addAttribute("amount",amount);
//        model.addAttribute("rate",rate);
//        return "index";                             // ten file jsp
    }
}

