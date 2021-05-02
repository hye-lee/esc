package com.pro.esc.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pro.esc.shop.dao.ProductDTO;
import com.pro.esc.shop.service.ShopService;

@Controller
public class MainController {
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Model model) throws Exception {
		
		List<ProductDTO> list=shopService.selectTOP5();
		
		String proImgPath = "";
		
	    for(int i=0;i<list.size();i++)
	      {
	        int pathStartIndex=list.get(i).getProImgPath().indexOf("resources");
	         System.out.println("pathStartIndex: "+pathStartIndex);
	         if(pathStartIndex > -1){
	        	 proImgPath = list.get(i).getProImgPath().substring(pathStartIndex);
	         } else {
	        	 proImgPath = "resources/images/shop/product12.jpg";
	         }
	         
	         list.get(i).setProImgPath(proImgPath);
	      }
		
		model.addAttribute("list",list);
		
		return "main/main.tiles";
	}
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest req, HttpSession session, ModelMap model){
	
		String userID=req.getParameter("userID");
		
		if(session.getAttribute("login")==null ) {
			
			if(userID!=null || userID!="") {
				System.out.println("userID:" +userID);
				model.addAttribute("userID",userID);
			}
			
			return "login/login.tiles";
		}
		return "redirect:/";
				
	}
	
}
