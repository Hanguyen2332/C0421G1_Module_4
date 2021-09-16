package com.practice.model.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Category() {
    }

    public Category(Integer id, String name, Set<Blog> blogSet) {
        this.id = id;
        this.name = name;
        this.blogSet = blogSet;
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

    //OneToMany
    @OneToMany(mappedBy = "category")
    private Set<Blog> blogSet;

}
