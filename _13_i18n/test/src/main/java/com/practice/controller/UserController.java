package com.practice.controller;

import com.practice.model.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/home")
    public ModelAndView create(){
        return new ModelAndView("index","userObj",new User());
    }
}
