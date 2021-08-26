package ex2.model.service;

import ex2.model.bean.Email;
import ex2.model.bean.MedicalDeclaration;
import ex2.model.repository.IMedicalDeclaration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDeclarationSerViceImpl implements IMedicalDeclarationSerVice {
    @Autowired
    private IMedicalDeclaration iMedicalDeclaration;
    @Override
    public MedicalDeclaration showDeclaredInfor() {
        return iMedicalDeclaration.showDeclaredInfor();
    }

    @Override
    public void saveInfor(MedicalDeclaration object) {
        iMedicalDeclaration.saveInfor(object);
    }
}
