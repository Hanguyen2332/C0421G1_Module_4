package com.practice.controller;

import com.practice.model.dto.CartDto;
import com.practice.model.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("cart")
public class CartController {

    //thanh toán (xóa giỏ hàng):
    @GetMapping({"/payment"})
    public ModelAndView payment(@SessionAttribute CartDto cart) {
        cart.getProductMap().clear();

        ModelAndView mav = new ModelAndView("cart/payment");
        mav.addObject("message","Bạn đã hoàn thành thanh toán");

        return mav;
    }


    //xem gio hang:
    @GetMapping({"", "/view_cart"})
    public ModelAndView showCart(@SessionAttribute CartDto cart) {

        ModelAndView mav = new ModelAndView("cart/cart_list");
        //tính tổng tiền
        mav.addObject("sumPrice", cart.sumPrice());
        //hiển thị list gio hang:
        mav.addObject("cartList", cart.getProductMap());
        return mav;
    }

    //chi tiet sp:
    @GetMapping("/view/{id}")
    public String showDetail(@PathVariable Long id,
                             @SessionAttribute CartDto cart,
                             Model model) {
        Optional<ProductDto> productDtoOptional = cart.findById(id);
        if (productDtoOptional.isPresent()) {
            model.addAttribute("productObj", productDtoOptional.get());
            return "cart/detail";
        }
        return "/cart/error";
    }

    //delete - chưa code form
    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable Long id,
                             @SessionAttribute CartDto cart, Model model) {
        model.addAttribute("productObj", cart.findById(id).get());
        return "cart/delete";
    }


    @PostMapping("/delete")
    public String delete(@ModelAttribute ProductDto productObj,
                         @SessionAttribute CartDto cart) {
        Long id = productObj.getId();
        Optional<ProductDto> productDtoOptional = cart.findById(id);
        if (!productDtoOptional.isPresent()) {
            return "/cart/error";
        } else {
            //gọi hàm xóa:
            cart.deleteById(id);
            return "redirect:/cart/view_cart";
        }
    }

    //update giỏ hàng:
    @GetMapping("/update/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute CartDto cart,
                            @RequestParam("action") String action) {
        Optional<ProductDto> productDtoOptional = cart.findById(id);
        if (!productDtoOptional.isPresent()) { //nếu sp không tồn tại -->báo lỗi
            return "/cart/error";
        } else {  //nếu có:
            ProductDto item = productDtoOptional.get();
            if (action.equals("add")) {  //tăng SL
                cart.addCart(item);
            } else if (action.equals("sub")) {  //Giảm SL
                cart.subCart(item);
            }
            //Trả về giỏ hàng
            return "redirect:/cart/view_cart";
        }
    }
}
