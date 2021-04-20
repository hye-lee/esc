package com.pro.esc.register.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.esc.login.dao.UserDTO;


@Repository
public class RegisterDaoImpl implements RegisterDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int selectReg(UserDTO userDTO) throws Exception{
		RegisterDao mapper=sqlSession.getMapper(RegisterDao.class);
		return mapper.selectReg(userDTO);
	}

	
	@Override
	public boolean insertReg(UserDTO userDTO) throws Exception{
		RegisterDao mapper=sqlSession.getMapper(RegisterDao.class);
		return mapper.insertReg(userDTO);
		
	}
	
	
}
