package com.pro.esc.inquiry.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
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
	public void insertInquiry(InquiryVO inquiryVO) throws Exception {
		// TODO Auto-generated method stub
		
		InquiryDao mapper= sqlSession.getMapper(InquiryDao.class);
		mapper.insertInquiry(inquiryVO);
		
	}

	@Override
	public List<InquiryVO> selectInquiry(InquiryVO inquiryVO) throws Exception {
		// TODO Auto-generated method stub
		InquiryDao mapper= sqlSession.getMapper(InquiryDao.class);
		
		return mapper.selectInquiry(inquiryVO);
	}

	@Override
	public InquiryVO selectOneInquiry(String inquirySeq) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.getMapper(InquiryDao.class).selectOneInquiry(inquirySeq);
	}

	@Override
	public void updateCnt(String inquirySeq) throws Exception {
		
		sqlSession.getMapper(InquiryDao.class).updateCnt(inquirySeq);
		
	}

	@Override
	public int inquiryCount() throws Exception {
		
		InquiryDao mapper= sqlSession.getMapper(InquiryDao.class);
		return mapper.inquiryCount();
	}

	@Override
	public void updateInquiry(InquiryVO inquiryVO) throws Exception {
		// TODO Auto-generated method stub
		InquiryDao mapper=sqlSession.getMapper(InquiryDao.class);
		mapper.updateInquiry(inquiryVO);
	}

	@Override
	public void deleteInquiry(String inquirySeq) throws Exception {
		// TODO Auto-generated method stub
		InquiryDao mapper=sqlSession.getMapper(InquiryDao.class);
		mapper.deleteInquiry(inquirySeq);
	}

	@Override
	public void insertInqReply(InquiryVO inquiryVO) throws Exception {
		// TODO Auto-generated method stub
		InquiryDao mapper=sqlSession.getMapper(InquiryDao.class);
		mapper.insertInqReply(inquiryVO);
	}

	@Override
	public InquiryVO selectRepInfo(HashMap<String,String> map) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.getMapper(InquiryDao.class).selectRepInfo(map);
	}
	
	
	
	

}
