package com.pro.esc.shop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDaoImpl implements ShopDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertProduct(ProductDTO productDTO) throws Exception {
		// TODO Auto-generated method stub
			sqlSession.getMapper(ShopDao.class).insertProduct(productDTO);
	}

	@Override
	public List<ProductDTO> selectProList(HashMap<String,String> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ShopDao.class).selectProList(map);
	}

	@Override
	public List<ProductDTO> selectProListALL() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ShopDao.class).selectProListALL();
	}

}
