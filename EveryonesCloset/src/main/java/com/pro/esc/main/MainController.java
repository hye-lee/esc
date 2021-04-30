package com.pro.esc.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Model model) {
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
