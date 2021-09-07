package com.exercise.model.service;

import com.exercise.entity.Code;

public interface ICodeService {
    void save(Code code);

    Code findByCode(Long code);

    public void deleteById(Code code);
}
