package ex1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ex1.model.bean.Email;
import ex1.model.service.IEmailService;


@Controller
public class EmailController {
    @Autowired
    private IEmailService iEmailService;

    //hien thi cấu hình email
    @GetMapping({"", "/config"})
    public ModelAndView showConfig() {
        return new ModelAndView("index","emailConfig",iEmailService.showDetailEmail());
    }

    @GetMapping({"/update"})
    public ModelAndView updateForm() {
        ModelAndView mav = new ModelAndView("update");
        mav.addObject("updateEmail",iEmailService.showDetailEmail());                      //doi tuong rong
        mav.addObject("languageList",iEmailService.showLanguages());  //language
        mav.addObject("pageSizeList",iEmailService.showPageSizeList());  //pageSize

        return mav;
    }
//    //update
    @PostMapping(value = "/update")
    public String convertCurrency(@ModelAttribute Email updateEmail,  //uu diem: KHONG cần get ra từng thuộc tính của input --> set cho thuộc tính của object
                                  RedirectAttributes redirectAttributes) {
        //goi ham
        iEmailService.update(updateEmail);
        //Hien thong bao:
        redirectAttributes.addFlashAttribute("message","Update Successfully!");
        //chuye huong ve trang list:
        return "redirect:/config";
    }
}

