package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    //part 1:
    public String greeting() {
        return "index";
    }

    //part 2:
//    public String greeting(@RequestParam String name, Model model) {
//        model.addAttribute ("name",name);
//        return "index";
//    }
}

