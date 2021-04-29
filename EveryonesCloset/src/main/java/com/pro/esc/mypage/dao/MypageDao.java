package com.pro.esc.mypage.dao;

import java.util.HashMap;

import com.pro.esc.login.dao.UserDTO;

public interface MypageDao {
	UserDTO selectUserOne(String userID)throws Exception;
	
	String checkUserPw(HashMap<String, String> map)throws Exception;
}
