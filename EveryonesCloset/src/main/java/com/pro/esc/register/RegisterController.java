package com.pro.esc.register;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.esc.login.dao.UserDTO;
import com.pro.esc.register.service.RegisterService;
import com.pro.esc.register.service.SHA256;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value="/registerForm")
	public String registerForm() {
		return "register/regForm.tiles";
	}
	
	@RequestMapping(value="/registerCom")
	public String welcome() {
		return "register/welcome.tiles";
	}
	
	
	@RequestMapping(value="/register")
	@ResponseBody
	public String registerUser(HttpServletRequest req, HttpSession session) throws Exception {
		String userID=req.getParameter("userID");
		String userPw=req.getParameter("userPw");
		String userAddr=req.getParameter("userAddr");
		String encryPw=SHA256.encrypt(userPw); //비밀번호 암호화
		System.out.println("encryPw: "+encryPw);
		

		UserDTO userDTO=new UserDTO();
		userDTO.setUserID(req.getParameter("userID"));
		userDTO.setUserEmail(req.getParameter("userEmail"));
		userDTO.setUserName(req.getParameter("userName"));
		userDTO.setUserPw(encryPw);
		userDTO.setUserAddr(userAddr);
		userDTO.setUserExAddr(req.getParameter("userExAddr"));
		userDTO.setUserPostCode(req.getParameter("userPostCode"));
		
		System.out.println(userID);

		if(registerService.insertReg(userDTO)) {
			session.setAttribute("login", userID);
			
			return "/registerCom";
		}
		
		return "/registerForm";
	}
	
	
	//email 검사용
		public boolean isValidEmail(String email) {
			boolean valid = false;
			String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
			Pattern pattern=Pattern.compile(regex); //정규식으로부터 패턴 생성
			Matcher macher= pattern.matcher(email); //매치하면 true
			
			if(macher.matches()) {
				valid=true;
			}
			return valid;
		}
		
		@RequestMapping(value="/checkID", method=RequestMethod.POST ,produces = "application/text; charset=utf8")
		@ResponseBody
		public String checkID(@RequestParam String userID) throws Exception {
			UserDTO userDTO = new UserDTO();
			userDTO.setUserID(userID);
			System.out.println("userID: "+userID);
			if(registerService.selectReg(userDTO)!=0)
			{
				return "이미 사용중인 아이디입니다.";
			}
			return " ";
		}
		
		@RequestMapping(value="/checkEmail", method=RequestMethod.POST ,produces = "application/text; charset=utf8")
		@ResponseBody
		public String checkEmail(@RequestParam String userEmail) throws Exception {
			UserDTO userDTO = new UserDTO();
			userDTO.setUserID(userEmail);
			if(registerService.selectReg(userDTO)!=0)
			{
				return "이미 사용중인 이메일입니다.";
			}
			return " ";
		}

	
}
