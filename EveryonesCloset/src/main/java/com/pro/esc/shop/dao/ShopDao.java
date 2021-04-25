package com.pro.esc.shop.dao;

import java.util.HashMap;
import java.util.List;

public interface ShopDao {

	void insertProduct(ProductDTO productDTO) throws Exception;
	
	List<ProductDTO> selectProList(HashMap<String,String> map)throws Exception ;

	List<ProductDTO> selectProListALL() throws Exception;
	
	ProductDTO selectProOne(int proSeq) throws Exception;
}
