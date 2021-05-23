package com.pro.esc.mypage.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.esc.inquiry.dao.InquiryDTO;
import com.pro.esc.login.dao.UserDTO;
import com.pro.esc.order.dao.OrderDTO;

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

	@Override
	public List<InquiryDTO> selectMyInquiry(InquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MypageDao.class).selectMyInquiry(inquiryDTO);
	}

	@Override
	public int countMyInquiry(String userID) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MypageDao.class).countMyInquiry(userID);
	}

	@Override
	public List<OrderDTO> selectMyOrder(OrderDTO orderDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MypageDao.class).selectMyOrder(orderDTO);
	}

	@Override
	public List<MyOrderDTO> selectOrderDetail(HashMap<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MypageDao.class).selectOrderDetail(map);
	}

	@Override
	public int countMyOrder(String userID) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MypageDao.class).countMyOrder(userID);
	}

	@Override
	public OrderDTO selectOrderDetailRec(String ordSeq) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MypageDao.class).selectOrderDetailRec(ordSeq);
	}

	@Override
	public int updataUserInfo(UserDTO userDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MypageDao.class).updataUserInfo(userDTO);
	}
	
}
