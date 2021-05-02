package com.pro.esc.order;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pro.esc.cart.dao.CartDTO;
import com.pro.esc.cart.service.CartService;
import com.pro.esc.login.dao.UserDTO;
import com.pro.esc.mypage.service.MypageService;
import com.pro.esc.order.dao.OrderDTO;
import com.pro.esc.order.dao.OrderProductDTO;
import com.pro.esc.order.service.OrderService;
import com.pro.esc.shop.service.ShopService;

@Controller
public class OrderController {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private MypageService myService;

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/orderDetail") //@RequestParam("choosePro")String[] cartSeq
	public String sendOrder(HttpServletRequest req, HttpSession session, ModelMap map) throws Exception {
		
		String[] cartSeq=(String[]) req.getAttribute("choosePro");
		
		System.out.println("cartSeq::"+cartSeq.length);
		
		List<CartDTO> list=new ArrayList<CartDTO>();

		CartDTO cartDTO=new CartDTO();
		String userID=(String)session.getAttribute("login");
		
		if(userID==null) {
			return "redirect:/login";
		}
		
	
		UserDTO userDTO=myService.selectUserOne(userID);
		userDTO.setUserID(userID);
		
		if(cartSeq!=null) {
			
			for(int i=0;i<cartSeq.length;i++) {
				{
					cartDTO=orderService.selectOrderProduct(Integer.parseInt(cartSeq[i]));
					
					String proImgPath="";
					int startIndex=cartDTO.getProImgPath().indexOf("resources");
					
					if(startIndex>-1)
					{	proImgPath=cartDTO.getProImgPath().substring(startIndex);
					}else {
						proImgPath="resources/images/shop/product12.jpg";
					}
					cartDTO.setProImgPath(proImgPath);
					
					list.add(cartDTO);
					
				}
			}
		}


		map.addAttribute("user",userDTO);
		map.addAttribute("list",list);
		
		return "order/orderPage.tiles";
	}
	
	@RequestMapping("completeOrder")
	public String order(@ModelAttribute("orderDTO") OrderDTO orderDTO,
			@ModelAttribute("orderProductDTO") OrderProductDTO orProDTO,
			@RequestParam ("cartSeq")int[] cartSeq, 
			@RequestParam("proSeq")int[] proSeq, HttpServletRequest req, HttpSession session, ModelMap model) throws Exception{
		
		int count=0;
		String userID=(String)session.getAttribute("login");
		orderDTO.setUserID(userID);
		for(int i=0;i<proSeq.length;i++)
		{
			HashMap<String,Object> map=new HashMap<String, Object>();
			map.put("userID", userID);
			map.put("proSeq", proSeq[i]);
			if(orderService.existOrder(map)>1)
				{ model.addAttribute("msg","이미 구입한 상품입니다.");
				count++;
				}
		}
		
		if(count==0)
		{
			//ordSeq생성
			String ordSeq="";
			
			Calendar cal=Calendar.getInstance();
			
			int year=cal.get(Calendar.YEAR);
			String month=year+new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
			String day=month+new DecimalFormat("00").format(cal.get(Calendar.DATE));
			String num="";
			
			for(int i=0;i<7;i++)
			{
				num+=(int)(Math.random()*10); //랜덤숫자
			}
			ordSeq=day+"_"+num;
			////
			
			orderDTO.setOrdSeq(ordSeq);
			orProDTO.setOrdSeq(ordSeq);

			orderService.insertOrder(orderDTO);

			CartDTO cart=new CartDTO();
			System.out.println("cartSeq길이::"+cartSeq.length);
			System.out.println("proSeq길이::"+proSeq.length);
			if(cartSeq.length==proSeq.length)
			{
				for(int i=0;i<cartSeq.length;i++) {
					orProDTO.setProSeq(proSeq[i]);
					orderService.insertOrderPro(orProDTO);
					shopService.updateStock(proSeq[i]);//재고 업데이트
					
					cart.setCartSeq(cartSeq[i]);
					cart.setUserID(userID);
					cartService.deleteCartOne(cart); //장바구니 삭제
				}
			}
			
			model.addAttribute("order",orderDTO);
		}
		else {
			
			 model.addAttribute("msg","이미 구입한 상품입니다.");
		}

		return "order/orderSuccess.tiles";
	}
}
