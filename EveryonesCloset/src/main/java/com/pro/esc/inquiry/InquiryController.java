package com.pro.esc.inquiry;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pro.esc.inquiry.dao.InquiryDTO;
import com.pro.esc.inquiry.dao.PageDto;
import com.pro.esc.inquiry.service.InquiryService;

@Controller
public class InquiryController {
	
	@Autowired
	private InquiryService inquiryService;
	
	//페이징+글목록
	@RequestMapping(value="/inquiry")
	public String inquiry(@ModelAttribute("inquiryDTO") InquiryDTO inquiryDTO,
			@RequestParam(defaultValue="1") int page, Model model,HttpSession session) throws Exception {
		
		String checkSession=(String) session.getAttribute("login");
		
		int count=inquiryService.inquiryCount();
		PageDto pageDto=new PageDto(count,page);
		inquiryDTO.setStartIndex(pageDto.getStartInx());
		inquiryDTO.setCntPerPage(pageDto.getRowCount());
		
		List<InquiryDTO> list=inquiryService.selectInquiry(inquiryDTO);
		model.addAttribute("list",list);
		model.addAttribute("count", count);
		model.addAttribute("pageDto", pageDto);
		model.addAttribute("checkSession",checkSession);
		
		return "inquiry/inquiryList.tiles";
	}
	
	@RequestMapping(value="/write")
	public String inquiryWrite(HttpServletRequest req, ModelMap modelMap) throws Exception {
		
		String inquirySeq = req.getParameter("inquirySeq");
		String inquiryParent= req.getParameter("inquiryParent");
		String userID= req.getParameter("userID");
		System.out.println("inquiryParent: "+inquiryParent );
		System.out.println("userID: "+userID );
		System.out.println("글쓰기페이지inquirySeq"+inquirySeq);
		
		return "inquiry/inquiryWrite.tiles";
	}
	
	@RequestMapping(value="/modify")
	public String inquiryModify(HttpServletRequest req, ModelMap modelMap, Model model) throws Exception {
		
		String inquirySeq=req.getParameter("inquirySeq");
		
		InquiryDTO info=new InquiryDTO();
		info= inquiryService.selectOneInquiry(inquirySeq);
		modelMap.addAttribute("info", info);
		model.addAttribute("plag","modify");
		
		return "inquiry/inquiryWrite.tiles";
	}
	
	
	@RequestMapping(value="/reply")
	public String inquiryReply(HttpServletRequest req, ModelMap modelMap, Model model)throws Exception{
		
		String inquirySeq = req.getParameter("inquirySeq");
		String inquiryParent= req.getParameter("inquiryParent");
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("inquiryParent",inquiryParent);
		map.put("inquirySeq",inquirySeq);
		InquiryDTO info=new InquiryDTO();
		info= inquiryService.selectRepInfo(map);
		model.addAttribute("plag","reply");
		modelMap.addAttribute("info",info);
		
		return "inquiry/inquiryWrite.tiles"; //저장후 글목록으로
	}
	
	@RequestMapping(value="replySave")
	public String ReplySave(HttpServletRequest req) throws Exception{
		
		String inquiryParent=req.getParameter("inquiryParent");
		String inquirySeqOrd=req.getParameter("inquirySeqOrd");
		String inquiryIndent=req.getParameter("inquiryIndent");

		InquiryDTO dto=new InquiryDTO();
		
		dto.setInquiryParent(Integer.parseInt(inquiryParent));
		dto.setInquirySeqOrd(Integer.parseInt(inquirySeqOrd));
		inquiryService.updateInqReSeq(dto);
		
		dto.setInquiryTitle(req.getParameter("inquiryTitle"));
		dto.setInquiryContent(req.getParameter("inquiryContent"));
		dto.setUserID(req.getParameter("userID"));
		
		dto.setInquiryIndent(Integer.parseInt(inquiryIndent));
		
		inquiryService.insertInqReply(dto);
		
		
		return "redirect:/inquiry";
	}
	
	//RequestParam으로 값을 받아와서 실행해봄
	@RequestMapping(value="inquirySave")
	public String inquirySave(@RequestParam("userID") String userID,
							@RequestParam("inquirySeq") String inquirySeq,
							@RequestParam("inquiryTitle") String inquiryTitle,
							@RequestParam("inquiryContent") String inquiryContent,
							HttpServletRequest req) throws Exception {
	
		String inquiryParent=req.getParameter("inquiryParent");
		String inquirySeqOrd=req.getParameter("inquirySeqOrd");
		String inquiryIndent=req.getParameter("inquiryIndent");
		System.out.println("저장inquirySeq"+inquirySeq);

		InquiryDTO inquiryDTO=new InquiryDTO();
		inquiryDTO.setInquiryTitle(inquiryTitle);
		inquiryDTO.setInquiryContent(inquiryContent);
		inquiryDTO.setUserID(userID);

		
		if(inquirySeq==""||"".equals(inquirySeq)||"0".equals(inquirySeq))
		{
				inquiryService.insertInquiry(inquiryDTO);
			
		}else {
			inquiryDTO.setInquirySeq(Integer.parseInt(inquirySeq));
			inquiryService.updateInquiry(inquiryDTO);
		}
			
		return "redirect:/inquiry";
	}
	
	@RequestMapping(value="read")
	public String inquiryRead(HttpServletRequest req, ModelMap modelMap) throws Exception{
		
		
		String inquirySeq=req.getParameter("inquirySeq");
		String inquiryParent=req.getParameter("inquiryParent");
		String inquirySeqOrd=req.getParameter("inquirySeqOrd");
		String inquiryIndent=req.getParameter("inquiryIndent");
		
		inquiryService.updateCnt(inquirySeq); //조회수 증가

		InquiryDTO info=inquiryService.selectOneInquiry(inquirySeq); //글 select
		
		modelMap.addAttribute("info",info);
		
		return"inquiry/inquiryView.tiles";
		
	}
	
	
	@RequestMapping(value="delete")
	public String delete(HttpServletRequest req)throws Exception{
		
		String inquirySeq=req.getParameter("inquirySeq");
		
		inquiryService.deleteInquiry(inquirySeq);
		
		return "redirect:/inquiry";
	}

}
