package com.exercise.model.service;

import com.exercise.entity.Code;
import com.exercise.model.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements ICodeService {
    @Autowired
    private CodeRepository codeRepository;
    @Override
    public void save(Code code) {
        codeRepository.save(code);
    }

    @Override
    public Code findByCode(Long code) {
        return codeRepository.findByCode(code);
    }

    @Override
    public void deleteById(Code code) {
//        codeRepository.deleteById(id);
        codeRepository.delete(code);

    }
}
