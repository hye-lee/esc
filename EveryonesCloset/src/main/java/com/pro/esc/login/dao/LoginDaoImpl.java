package com.pro.esc.login.dao;

import java.util.HashMap;

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

	@Override
	public String findId(HashMap<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(LoginDao.class).findId(map);
	}

	@Override
	public int findPw(HashMap<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(LoginDao.class).findPw(map);
	}

	@Override
	public int updatePw(HashMap<String, String> map) throws Exception {
		return sqlSession.getMapper(LoginDao.class).updatePw(map);
	}

}
