package com.practice.controller;

import com.practice.model.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/home")
    public ModelAndView create(){
        return new ModelAndView("index","userObj",new User());
    }

    @PostMapping("/doLogin")
    public ModelAndView doLogin(@ModelAttribute User user) {
        if(user.getUserName().equals("admin") && user.getPassword().equals("123456")){
            return new ModelAndView ("success","user", user);
        }
        return new ModelAndView("error");
    }
}
