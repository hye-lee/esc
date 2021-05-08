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
	public List<ProductDTO> selectProList(HashMap<String,Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ShopDao.class).selectProList(map);
	}

	@Override
	public List<ProductDTO> selectProListALL() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ShopDao.class).selectProListALL();
	}

	@Override
	public ProductDTO selectProOne(int proSeq) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ShopDao.class).selectProOne(proSeq);
	}

	@Override
	public void updateStock(int proSeq) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.getMapper(ShopDao.class).updateStock(proSeq);
		
	}

	@Override
	public List<ProductDTO> selectTOP5() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ShopDao.class).selectTOP5();
	}

	@Override
	public int productCount(HashMap<String,Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ShopDao.class).productCount(map);
	}

}
