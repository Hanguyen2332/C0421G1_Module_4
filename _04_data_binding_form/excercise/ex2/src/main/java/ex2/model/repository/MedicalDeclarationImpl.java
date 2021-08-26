package ex2.model.repository;

import ex2.model.bean.MedicalDeclaration;
import org.springframework.stereotype.Repository;


@Repository
public class MedicalDeclarationImpl implements IMedicalDeclaration {
    private static MedicalDeclaration medicalDeclaration = null;

    @Override
    public MedicalDeclaration saveInfor(MedicalDeclaration object) {
        return medicalDeclaration = object;
    }

    @Override
    public MedicalDeclaration showDeclaredInfor() {
        return medicalDeclaration;
    }
}

