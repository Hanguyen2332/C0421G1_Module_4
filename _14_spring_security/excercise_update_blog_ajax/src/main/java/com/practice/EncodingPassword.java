package com.practice;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodingPassword {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("444"));
    }
}
