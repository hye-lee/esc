package com.pro.esc.mypage.dao;

import com.pro.esc.login.dao.UserDTO;

public interface MypageDao {
	UserDTO selectUserOne(String userID)throws Exception;
}
