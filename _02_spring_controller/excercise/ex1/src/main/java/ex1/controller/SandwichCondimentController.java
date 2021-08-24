package ex1.controller;

import ex1.model.service.ICondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SandwichCondimentController {
    @Autowired
    ICondimentService iConvertService;

    //hien thi form
    @GetMapping({"", "/condiment"})
    public ModelAndView showCondiment(ModelAndView modelAndView) {
        List<String> condimentList = iConvertService.showCondiments();
        return new ModelAndView("index", "condimentList", condimentList);
    }

    //Save Condiment
    @GetMapping(value = "/save_condiment")
    public ModelAndView convertCurrency(@RequestParam String[] selectedCon) {

        return new ModelAndView("show_selection", "selectedCon", selectedCon);
    }
}

