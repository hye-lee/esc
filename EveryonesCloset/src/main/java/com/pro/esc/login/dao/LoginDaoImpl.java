package com.pro.esc.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int login(UserDTO userDTO) throws Exception {
		LoginDao mapper= sqlSession.getMapper(LoginDao.class);
		return mapper.login(userDTO);
	}

}
