package com.pro.esc.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.esc.login.service.LoginService;

@Controller
public class LoginContoller {
	
	@Autowired
	private LoginService loginService;

	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam String userID, @RequestParam String userPw,
			HttpSession session) throws Exception {
		
		System.out.println(userID);
        System.out.println(userPw);
       
        UserVO userVO=new UserVO();
        userVO.setUserID(userID);
        userVO.setUserPw(userPw);
        
        if(loginService.login(userVO)==1)
        {
        	System.out.println(loginService.login(userVO));
        	session.setAttribute("login", userID);
        	return "success";
        }
		
		return "fail";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "VerifyRecaptcha", method = RequestMethod.POST)
	public int VerifyRecaptcha(HttpServletRequest request) {
	    VerifyRecaptcha.setSecretKey("6LdO76YaAAAAAO02upNitNmkOACJ4t-_54jC2wJb");
	    String gRecaptchaResponse = request.getParameter("recaptcha");
	    try {
	       if(VerifyRecaptcha.verify(gRecaptchaResponse))
	          return 0; // 성공
	       else return 1; // 실패
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1; //에러
	    }
	}

}
