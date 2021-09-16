package com.practice.model.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String password;
    private boolean isEnable;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_user",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId" ))
    private Set<Role> roleSet;

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
