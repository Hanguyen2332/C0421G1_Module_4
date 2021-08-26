package ex2.controller;


import ex2.model.bean.MedicalDeclaration;
import ex2.model.service.IMedicalDeclarationSerVice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MedicalDeclarationController {
    @Autowired
    private IMedicalDeclarationSerVice medicalDeclarationSerVice;

    @GetMapping({"","/show_detail"})
    public ModelAndView showObject() {
        ModelAndView mav = new ModelAndView("show_detail");
        mav.addObject("object",medicalDeclarationSerVice.showDeclaredInfor());                      //doi tuong rong
        return mav;
    }
    //hien thi cấu hình email
    @GetMapping({"/medical_declaration"})
    public ModelAndView showForm() {
        ModelAndView mav = new ModelAndView("index");
//        object rỗng
        MedicalDeclaration medicalDeclaration =  new MedicalDeclaration();
        mav.addObject("medicalDeclaration",medicalDeclaration);
        // giới tính
        String[] gender = {"Nam","Nữ","LGBT"};
        mav.addObject("gender",gender);
        //quốc tịch
        String[] nationality = {"Việt Nam","Trung Quốc","Nhật Bản","Hàn Quốc"};
        mav.addObject("nationality",nationality);
        //Transportation
        String[] transportations = {"Tàu bay","Tàu thuyền","Ô tô","Khác (ghi rõ)"};
        mav.addObject("transportations",transportations);
        //provinces
        String[] provinces = {"Đà Nẵng","Hà Nội","Hồ Chí Minh","ĐăkLăk"};
        mav.addObject("provinces",provinces);
        //district
        String[] districts = {"Cẩm Lệ","Thanh Khê","Hai Bà Trưng","Hoàn Kiếm","Quận 1","Thủ Đức","Buôn Hồ","Buôn Mê Thuột"};
        mav.addObject("districts",districts);
        //district
        String[] towns = {"Hòa Cường","Khuê Trung","Thạc Gián","Cống Vị","Kim Mã", "Giảng Võ","Bến Nghé","Bến Thành","Cô Giang","Quảng Tiến","Quảng Nhiêu"};
        mav.addObject("towns",towns);
        //triệu chứng
        String[] diseaseSymptoms = {"Sốt","Ho","Khó Thở","Đau họng","Nôn/buồn nôn", "Tiêu chảy","Xuất huyết ngoài da","Nổi ban ngoài da"};
        mav.addObject("diseaseSymptoms",diseaseSymptoms);
        //Lịch sử phơi nhiễm
        String[] exposureHistory = {"Đến trang trại chăn nuôi/chợ bán động vật/cơ sở giết mổ","Tiếp xúc gần (<2m) với người nhiễm nhiễm nCoV"};
        mav.addObject("exposureHistory",exposureHistory);
        return mav;
    }

    @PostMapping(value = "/save_infor")
    public String saveMedicalDeclaration(@ModelAttribute MedicalDeclaration medicalDeclaration,  //uu diem: KHONG cần get ra từng thuộc tính của input --> set cho thuộc tính của object
                                  RedirectAttributes redirectAttributes) {
        //goi ham
        medicalDeclarationSerVice.saveInfor(medicalDeclaration);
        //Hien thong bao:
        redirectAttributes.addFlashAttribute("message","Gửi tờ khai thành công!");
        //chuye huong ve trang list:
        return "redirect:/show_detail";
    }
}

