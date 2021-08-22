package ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Customer {
    @GetMapping("/customer") // localhost8080/customer
    public String convert() {
        return "index";
    }
}
