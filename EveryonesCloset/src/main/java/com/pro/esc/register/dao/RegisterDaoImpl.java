package com.pro.esc.register.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.esc.login.UserVO;

@Repository
public class RegisterDaoImpl implements RegisterDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int selectReg(UserVO userVO) throws Exception{
		RegisterDao mapper=sqlSession.getMapper(RegisterDao.class);
		return mapper.selectReg(userVO);
	}

	
	@Override
	public boolean insertReg(UserVO userVO) throws Exception{
		RegisterDao mapper=sqlSession.getMapper(RegisterDao.class);
		return mapper.insertReg(userVO);
		
	}
	
	
}
