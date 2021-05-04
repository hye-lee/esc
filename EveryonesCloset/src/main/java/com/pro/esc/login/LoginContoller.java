package com.pro.esc.login;

import java.util.HashMap;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.esc.login.dao.UserDTO;
import com.pro.esc.login.service.LoginService;
import com.pro.esc.register.service.SHA256;

@Controller
public class LoginContoller {
	
	@Autowired
	private LoginService loginService;
	
	//메일보내기
    @Autowired
    private JavaMailSender mailSender;

	
	@RequestMapping(value="/trylogin",method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam String userID, @RequestParam String userPw,
			HttpSession session) throws Exception {
		
		System.out.println(userID);
        System.out.println(userPw);
        String encryPw=SHA256.encrypt(userPw);
        UserDTO userDTO=new UserDTO();
        userDTO.setUserID(userID);
        userDTO.setUserPw(encryPw);
        
        if(loginService.login(userDTO)==1)
        {
        	System.out.println(loginService.login(userDTO));
        	session.setAttribute("login", userID);
        	String admin="";
        	admin=loginService.selectadmin(userDTO);
        	if(admin!=null) {
        		session.setAttribute("admin", "Y");
        		System.out.println("admin::Y");
        	}
        	
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
	
	@RequestMapping(value="login/findId")
	public String pageFindId() {
		
		return "login/findId.tiles";
		
	}
	
	@RequestMapping(value="login/findPw")
	public String pageFindPw(HttpServletRequest req,ModelMap model) {
		
		String userID=req.getParameter("userID");
		
		if(userID!=null || userID!="") {
			System.out.println("userID:" +userID);
			model.addAttribute("userID",userID);
		}
		
		
		return "login/findPw.tiles";
		
	}

	@RequestMapping(value="login/reFindId")
	public String findId(@RequestParam("userName") String userName,
						@RequestParam("userEmail")String userEmail, ModelMap model) throws Exception {
		
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("userName", userName);
		map.put("userEmail", userEmail);
		
		String userId=loginService.findId(map);
		
		model.addAttribute("userId",userId);
		
		return "login/resultId.tiles";
	}
	
	@RequestMapping(value="login/reFindPw")
	public String findPw(@RequestParam("userID") String userID,
						@RequestParam("userEmail")String userEmail, ModelMap model) throws Exception {
		
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("userID", userID);
		map.put("userEmail", userEmail);
		

			//임시 비밀번호 생성
		String uuid = UUID.randomUUID().toString().replaceAll("-", ""); // -를 제거해줌.  
	    uuid = uuid.substring(0, 8); //uuid를 앞에서부터 8자리 잘라줌.  
	    System.out.println(uuid);
	        
	        if(userEmail != "") {
	        	String setfrom = "meoba1175@gmail.com";         
	            String tomail  =  userEmail;    				// 받는 사람 이메일
	            String title   = "[ESC] 임시비밀번호를 보내드립니다.";     			// 제목
	            String content = "귀하의 임시비밀번호는  [ " + uuid + " ] 입니다.";   	// 내용
	            SHA256 sha256 = new SHA256();
	            String newPw = sha256.encrypt(uuid);					//암호화
	            
	            map.put("userPw", newPw);
	            if(loginService.updatePw(map)==1) {
	            	System.out.println("성공");
	            }
	            model.addAttribute("userEmail",userEmail);
	            
	            try {
	            	MimeMessage message = mailSender.createMimeMessage();
	            	MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
	            	messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	            	messageHelper.setTo(tomail);     // 받는사람 이메일
	            	messageHelper.setSubject(title); // 메일제목은 생략 가능
	            	messageHelper.setText(content);  // 메일 내용
	             
	            	mailSender.send(message);
	            } catch(Exception e){
	            	System.out.println(e);
	            }
	        
	        }

		
		return "login/resultPw.tiles";
	}
}
