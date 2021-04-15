package com.pro.esc.main;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Model model) {
		return "main/main.tiles";
	}
	
	@RequestMapping(value="/login")
	public String login(HttpSession session){
		if(session.getAttribute("login")==null) {
			return "login/login.tiles";
		}
		return "redirect:/";
				
	}
	
}
