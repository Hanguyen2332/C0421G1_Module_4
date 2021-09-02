package com.practice.model.service;

import java.util.Optional;

public interface ICustomerService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}
