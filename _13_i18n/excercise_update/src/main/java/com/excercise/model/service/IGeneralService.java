package com.excercise.model.service;

import java.util.Optional;

public interface IGeneralService<T> {

    Iterable<T> findAll();

    void save(T t);

}
