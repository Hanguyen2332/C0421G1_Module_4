package ex2.model.service;

import ex2.model.bean.Email;
import ex2.model.bean.MedicalDeclaration;

import java.util.List;

//@Service
public interface IMedicalDeclarationSerVice {
    //hiển thị thông tin khai báo
    public MedicalDeclaration showDeclaredInfor();


    //lưu thông tin khai báo
    public void saveInfor(MedicalDeclaration object);
}
