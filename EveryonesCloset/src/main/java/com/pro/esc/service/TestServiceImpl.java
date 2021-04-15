package com.pro.esc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pro.esc.DAO.TestDAO;
import com.pro.esc.bean.TestBean;

@Service
public class TestServiceImpl implements TestService {

	@Inject
	private TestDAO dao;

	
	@Override
	public List<TestBean> test() throws Exception {

		// TODO Auto-generated method stub
		return dao.test();

	}



}