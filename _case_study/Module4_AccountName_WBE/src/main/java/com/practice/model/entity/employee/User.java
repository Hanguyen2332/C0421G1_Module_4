package com.practice.model.entity.employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = true)
//    private Integer userId;
    private String userName;
    private String password;


    //quan he 1-1: employee
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @OneToOne(mappedBy = "user")
    private Employee employee;

    //manyToMany: user
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "userName"),
            inverseJoinColumns = @JoinColumn(name = "idRole"))
    private List<Role> roleList;

    public User() {
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
