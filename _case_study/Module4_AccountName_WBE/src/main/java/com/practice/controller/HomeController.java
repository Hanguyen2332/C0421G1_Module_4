package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String startScreen () {
        return "home";
    }

    @GetMapping("/login")
    public String loginForm () {
        return "login";
    }

    @GetMapping("/403")
    public String error403Form () {
        return "403";
    }
//
//    @GetMapping("/error")
//    public String errorMess () {
//        return "error";
//    }
}
