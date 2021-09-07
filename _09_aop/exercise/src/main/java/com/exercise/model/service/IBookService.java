package com.exercise.model.service;

import com.exercise.entity.Book;

import java.util.List;

public interface IBookService {

    void save(Book book);

    List<Book> findAll();

    Book findById(Integer id);




}
