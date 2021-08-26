package ex2.model.repository;

import ex2.model.bean.Email;
import ex2.model.bean.MedicalDeclaration;

import java.util.List;

//@Repository
public interface IMedicalDeclaration {
    //hiển thị thông tin khai báo
    public MedicalDeclaration showDeclaredInfor();


    //lưu thông tin khai báo
    public MedicalDeclaration saveInfor(MedicalDeclaration object);

}
