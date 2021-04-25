package com.pro.esc.cart;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.esc.cart.dao.CartDTO;
import com.pro.esc.cart.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/cart")
	public String CartPage(HttpSession session,ModelMap map)throws Exception{
		
		String userID=(String) session.getAttribute("login");
		
		List<CartDTO> list=cartService.selectMyCart(userID);
		
		int totalPrice=0;
		
		if(list.size()!=0) {
			totalPrice=cartService.totalCartPrice(userID);
		}
		
		String proImgPath="";
		
		for(int i=0;i<list.size();i++)
		{
			int startIndex= list.get(i).getProImgPath().indexOf("resources");
			
			if(startIndex>-1)
			{
				proImgPath=list.get(i).getProImgPath().substring(startIndex);
			}else {
				proImgPath="resources/images/shop/product12.jpg";
			}
			
			list.get(i).setProImgPath(proImgPath);
		}
		
		map.addAttribute("list",list);
		
		map.addAttribute("total",totalPrice);
		
		return "cart/cartList.tiles";
	}
	
	@RequestMapping(value="/cart/insert")
	public String insertCart(@RequestParam("proSeq") int proSeq, HttpSession session)throws Exception{
		
		String userID=(String) session.getAttribute("login");
		CartDTO cartDTO=new CartDTO();
		cartDTO.setUserID(userID);
		cartDTO.setProSeq(proSeq);
		
		if(cartService.existCart(cartDTO)!=1) //중복 상품 장바구니담기 방지
		{
			cartService.insertCart(cartDTO);
		}
		
		return "redirect:/cart";
	}
	
	@RequestMapping(value="/cart/deleteOne")
	@ResponseBody
	public int deleteOne(@RequestParam("userID") String userID, @RequestParam("cartSeq")int cartSeq)throws Exception{
		
		CartDTO cartDTO=new CartDTO();
		cartDTO.setCartSeq(cartSeq);
		cartDTO.setUserID(userID);
		
		int result=0;
		
		if(cartService.deleteCartOne(cartDTO)==1)
		{
			result=1;
		}

		return result;
	}
	
	

}
