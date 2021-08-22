package ex2.controller;

import ex2.model.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
    @Autowired
    IDictionaryService iDictionaryService;

    @GetMapping("/translate")
    //Hien thi form translate:
    public String translateForm() {
        return "index";
    }

    //translate:
    @RequestMapping(value = "/translate", method = RequestMethod.POST)
    public ModelAndView translate(@RequestParam("english") String english) {
        String result = iDictionaryService.translate(english);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("english",english);
        modelAndView.addObject("vietnamese",result);
        return modelAndView;
    }
}

