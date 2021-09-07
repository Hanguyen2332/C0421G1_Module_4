package com.exercise.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bookName;
    private Integer quantity;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)  //xem lại quan hệ - nhiều --> FK?
    private Set<Code> codeSet;

    public Set<Code> getCodeSet() {
        return codeSet;
    }

    public void setCodeSet(Set<Code> codeSet) {
        this.codeSet = codeSet;
    }

    public Book() {
    }

    public Book(Integer id, String bookName, Integer quantity) {
        this.id = id;
        this.bookName = bookName;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
