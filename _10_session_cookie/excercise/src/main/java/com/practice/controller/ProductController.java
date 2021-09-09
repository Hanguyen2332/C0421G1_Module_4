package com.practice.controller;

import com.practice.model.dto.CartDto;
import com.practice.model.dto.ProductDto;
import com.practice.model.entity.Product;
import com.practice.model.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/shop")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    //hien thi list sp:
    @GetMapping
    public ModelAndView showList() {
        return new ModelAndView("list", "productList", iProductService.findAll());
    }
//
//    // Chưa viết code HTML
//    @GetMapping("/detail/{id}")
//    public ModelAndView showDetail(@PathVariable Long id) {
//        return new ModelAndView("detail", "productObj", iProductService.finById(id).get());
//    }

    //them gio hang:
    @GetMapping("/add_cart/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute CartDto cart,
                            RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = iProductService.finById(id);

        if (productOptional.isPresent()) { //nếu k null
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);  //Kiểu data từ DB: Product, kiểu đối tượng cần lưu map: ProductDto -->copy
            cart.addCart(productDto);  //lưu map
            redirectAttributes.addFlashAttribute("message", "Đã thêm " + productDto.getName() + "vào giỏ hàng");
        }

        return "redirect:/shop";

    }
}
