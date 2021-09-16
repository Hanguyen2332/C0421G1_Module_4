package com.practice.model.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MyUserDetails implements UserDetails {
    private User user;

    public MyUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {  //lấy ra các quyền của obj user
        Set<Role> roleSet = user.getRoleSet();
        List<GrantedAuthority> roles = new ArrayList<>();
        for (Role role: roleSet) {
            roles.add(new SimpleGrantedAuthority(role.getRoleName()));  //class implements của GrantedAuthority
        }
        return roles;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {  //tài khoản hết hạn?
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //bị khóa?
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //??
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isEnable();
    }
}
