package com.practice.model.service;

import com.practice.model.bean.MyUserDetails;
import com.practice.model.bean.User;
import com.practice.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User name: " + username + " not exist");
        }
        return new MyUserDetails(user);
    }
}
