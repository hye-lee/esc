package com.pro.esc.login.dao;

import java.util.HashMap;

public interface LoginDao {
	
	int login(UserDTO userDTO) throws Exception;
	
	String findId(HashMap<String,String> map)throws Exception;
	
	int findPw(HashMap<String,String> map)throws Exception;
	
	int updatePw(HashMap<String,String> map)throws Exception;

}
