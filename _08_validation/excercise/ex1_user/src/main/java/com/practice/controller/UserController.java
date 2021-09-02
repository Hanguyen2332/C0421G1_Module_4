package com.practice.controller;

import com.practice.model.dto.UserDto;
import com.practice.model.entity.User;
import com.practice.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public ModelAndView createUserForm() {
        return new ModelAndView("create","userDto",new UserDto());
    }

    @PostMapping("/create")
    public ModelAndView createUser(@Valid @ModelAttribute UserDto userDto,
                                   BindingResult bindingResult ) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("create","userDto",userDto); //có lỗi --> trả thông tin obj + lỗi về form create
        }else {
            User user = new User();
            BeanUtils.copyProperties(userDto,user); //copy userDto --> user
            iUserService.createUser(user); //goi ham save
            //response --> client:
            ModelAndView mav = new ModelAndView("result");
            mav.addObject("userDto",userDto);

            return mav;
        }
    }
}
