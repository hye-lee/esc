package com.pro.esc.inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pro.esc.inquiry.service.InquiryService;

@Controller
public class InquiryController {
	
	@Autowired
	private InquiryService inquiryService;
	
	@RequestMapping(value="/inquiry")
	public String inquiry() {
		return "inquiry/inquiryList.tiles";
	}
	
	@RequestMapping(value="/inquiryWrite")
	public String inquiryWrite() {
		return "inquiry/inquiryWrite.tiles";
	}

}
