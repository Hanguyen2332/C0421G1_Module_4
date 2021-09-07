package com.exercise.controller;

import com.exercise.entity.Book;
import com.exercise.entity.Code;
import com.exercise.exception.BookQuantityZero;
import com.exercise.exception.CodeNotExistException;
import com.exercise.model.service.IBookService;
import com.exercise.model.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private IBookService iBookService;

    @Autowired
    private ICodeService iCodeService;


    //show List book
    @GetMapping("")
    public ModelAndView showList() {
        return new ModelAndView("index", "bookList", iBookService.findAll());
    }

    @GetMapping("/borrow/{idBook}")
    public ModelAndView borrowForm(@PathVariable Integer idBook) {
        //tạo code random
        Code codeObj = new Code();
        //set code --> hiển thị mã cho client
        codeObj.setCode((long) (Math.random() * (99999 - 10000) + 10000));
        Book bookObj = iBookService.findById(idBook);
        //Set book cho table code
        codeObj.setBook(bookObj);

        return new ModelAndView("borrow", "codeObj", codeObj);
    }

    @PostMapping("/borrow")
    public String borrow(@ModelAttribute Code codeObj,
                       RedirectAttributes redirectAttributes) throws BookQuantityZero {

        if (codeObj.getBook().getQuantity() == 0) {
            throw new BookQuantityZero();
        } else {
            //lưu code (tạo mới):
            iCodeService.save(codeObj);
            //giam SL đi 1:
            Book bookObj = codeObj.getBook();
            bookObj.setQuantity(bookObj.getQuantity() - 1);
            //lưu book lại
            iBookService.save(bookObj);
            //response
            redirectAttributes.addFlashAttribute("message", "Bạn đã mượn sách: " + bookObj.getBookName());
            return "redirect:";
        }
    }

    //handle: TH SL = 0
    @ExceptionHandler(BookQuantityZero.class)
    public String handleBookQtyZero() {
        return "error_qty_zero";
    }

    //trả sách
    @GetMapping("/give_back/{idBook}")
    public ModelAndView giveBackForm(@PathVariable Integer idBook) {
        Code codeObj = new Code();
        return new ModelAndView("give_back", "codeObj", codeObj);
    }

    @PostMapping("/give_back")
    public String giveBack(@ModelAttribute Code codeObj,
                       RedirectAttributes redirectAttributes) throws CodeNotExistException {

        //lấy ra mã code đã input:
        Long code = codeObj.getCode();
        //find: có tồn tại mã/không?
        Code borrowCode = iCodeService.findByCode(code);
        if (borrowCode==null) {  //nếu không --> quăng lỗi:
            throw new CodeNotExistException();
        } else {
            //tăng SL đi 1:
            Book bookObj = borrowCode.getBook();
            bookObj.setQuantity(bookObj.getQuantity() + 1);
            //lưu sách lại
            iBookService.save(bookObj);
            //xóa code (chỉ dùng 1 lần)
            iCodeService.deleteById(borrowCode);
            //response
            redirectAttributes.addFlashAttribute("message", "Bạn đã trả sách: " + bookObj.getBookName());
            return "redirect:";
        }
    }

    //handle: mã không tồn tại
    @ExceptionHandler(CodeNotExistException.class)
    public String handleCodeNotExistEx() {
        return "error_code_not_found";
    }
}
