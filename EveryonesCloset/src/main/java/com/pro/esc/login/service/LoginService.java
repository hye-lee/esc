package com.pro.esc.login.service;

import java.util.HashMap;

import com.pro.esc.login.dao.UserDTO;

public interface LoginService {
	int login(UserDTO OuserDTO) throws Exception;
	
	String findId(HashMap<String, String> map)throws Exception;
	
	int findPw(HashMap<String,String> map)throws Exception;
	
	int updatePw(HashMap<String,String> map)throws Exception;
	
	String selectadmin(UserDTO userDTO)throws Exception;
}
