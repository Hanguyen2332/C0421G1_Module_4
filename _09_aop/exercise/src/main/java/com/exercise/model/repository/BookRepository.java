package com.exercise.model.repository;

import com.exercise.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository  extends JpaRepository<Book,Integer> {
}
