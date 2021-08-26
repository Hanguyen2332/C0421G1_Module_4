package com.model.service;

import com.model.bean.Login;
import com.model.bean.User;

public interface ICheckLoginService {
    User checkLogin(Login login);
}
