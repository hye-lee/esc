package com.pro.esc.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.esc.login.UserVO;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int login(UserVO userVO) {
		LoginDao mapper= sqlSession.getMapper(LoginDao.class);
		return mapper.login(userVO);
	}

}
