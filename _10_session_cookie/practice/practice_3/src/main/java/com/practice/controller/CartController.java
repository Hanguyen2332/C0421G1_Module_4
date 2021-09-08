package com.practice.controller;

import com.practice.model.dto.CartDto;
import com.practice.model.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("cart")
public class CartController {

    //xem gio hang:
    @GetMapping({"","/view_cart"})
    public ModelAndView showCart(@SessionAttribute CartDto cart) {

        ModelAndView mav = new ModelAndView("cart/cart_list");
        mav.addObject("sumPrice",cart.sumPrice());
        mav.addObject("cartList",cart.getProductMap());
        return mav;
    }

    //chi tiet sp:
    @GetMapping("/view/{id}")
    public String showDetail(@PathVariable Long id,
                             @SessionAttribute CartDto cart,
                             Model model) {
        Optional<ProductDto> productDtoOptional =  cart.findById(id);
        if (productDtoOptional.isPresent()) {
            model.addAttribute("productObj", productDtoOptional.get());
            return "cart/detail";
        }
        return "/cart/error";

//        return "redirect:/cart/view_cart";
    }

    //delete - chưa code form
    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable Long id,
                                   @SessionAttribute CartDto cart, Model model) {
        Optional<ProductDto> productDtoOptional =  cart.findById(id);
        if (productDtoOptional.isPresent()) {
            model.addAttribute("productObj", productDtoOptional.get());
            return "cart/delete";
        }
        return "/cart/error";
//        return "redirect:/cart/view_cart";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute ProductDto productObj,
                             @SessionAttribute CartDto cart) {
        //gọi hàm xóa:
        cart.deleteById(productObj.getId());
        return "redirect:/cart/view_cart";
    }

    //update giỏ hàng:
    @GetMapping("/update/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute CartDto cart,
                            @RequestParam("action") String action) {
        Optional<ProductDto> productDtoOptional =  cart.findById(id);
        if (!productDtoOptional.isPresent()) { //nếu sp không tồn tại -->báo lỗi
            return "/cart/error";
        }else {  //nếu có:
            ProductDto item = productDtoOptional.get();
            if (action.equals("add")) {  //tăng SL
                cart.addCart(item);
            }else if (action.equals("sub")){  //Giảm SL
                cart.addCart(item);
            }
            //Trả về giỏ hàng
            return "redirect:/cart/view_cart";
        }
    }
    //tính tổng tiền:

}
