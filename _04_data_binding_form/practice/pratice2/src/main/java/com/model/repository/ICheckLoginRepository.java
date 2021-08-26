package com.model.repository;

import com.model.bean.Login;
import com.model.bean.User;

public interface ICheckLoginRepository {
   User checkLogin(Login login);
}
