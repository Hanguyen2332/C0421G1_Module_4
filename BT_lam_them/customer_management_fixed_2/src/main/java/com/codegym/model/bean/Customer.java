package com.codegym.model.bean;

import javax.persistence.*;

@Entity(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String address;
    private String doNotUseKeyWord;  //đổi tên thuộc tính 'order' --> vì trùng vs key word (tương tự: having/group...)

    public Customer() {
    }

    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Customer(Integer id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoNotUseKeyWord() {
        return doNotUseKeyWord;
    }

    public void setDoNotUseKeyWord(String doNotUseKeyWord) {
        this.doNotUseKeyWord = doNotUseKeyWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
