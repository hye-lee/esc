package com.pro.esc.login.service;

import com.pro.esc.login.dao.UserDTO;

public interface LoginService {
	int login(UserDTO OuserDTO) throws Exception;
}
