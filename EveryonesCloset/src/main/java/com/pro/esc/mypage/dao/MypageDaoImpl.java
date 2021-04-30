package com.pro.esc.mypage.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.esc.login.dao.UserDTO;

@Repository
public class MypageDaoImpl implements MypageDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public UserDTO selectUserOne(String userID) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MypageDao.class).selectUserOne(userID); 
	}

	@Override
	public String checkUserPw(HashMap<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MypageDao.class).checkUserPw(map);
	}

	@Override
	public int updateUserStat(String userID) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MypageDao.class).updateUserStat(userID);
	}
	
}
