package com.model.service;

import com.model.bean.Login;
import com.model.bean.User;
import com.model.repository.ICheckLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckLoginService implements ICheckLoginService {
    @Autowired
    ICheckLoginRepository iCheckLoginRepository;

    @Override
    public User checkLogin(Login login) {
        return iCheckLoginRepository.checkLogin(login);
    }
}
