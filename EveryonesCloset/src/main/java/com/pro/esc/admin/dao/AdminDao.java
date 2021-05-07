package com.pro.esc.admin.dao;

import java.util.List;

import com.pro.esc.login.dao.UserDTO;
import com.pro.esc.shop.dao.ProductDTO;

public interface AdminDao {
	List<UserDTO> selectAllUser(String userID) throws Exception;
	
	int updateUserStat(String userID)throws Exception;
	
	List<ProductDTO> selectAllProduct()throws Exception;
}
