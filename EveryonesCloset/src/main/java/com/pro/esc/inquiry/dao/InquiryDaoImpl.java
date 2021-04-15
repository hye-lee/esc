package com.pro.esc.inquiry.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InquiryDaoImpl implements InquiryDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void insertInquiry(InquiryVO inquiryVO) throws Exception {
		// TODO Auto-generated method stub
		
		InquiryDao mapper= sqlSession.getMapper(InquiryDao.class);
		mapper.insertInquiry(inquiryVO);
		
	}

}
