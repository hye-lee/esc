package com.pro.esc.inquiry.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class InquiryVO {
	 	private int inquirySeq;                        // 글 번호
	 	private String userID;                          // 작성자
	    private int inquiryCnt;                        // 조회수
	    private String inquiryTitle;                      // 글 제목
	    private String inquiryContent;                    // 내용
	    private String inquiryStat;                    // 삭제 플래그
	    private String inquiryCate;                       // 게시판 종류
	    private int inquiryParent;					//부모글
	    private int inquiryDepth;					//깊이
	    private String inquiryRegDate;                    // 작성일
	    private String inquiryUpDate;					//수정일
	    private List<MultipartFile> inquiryFile;       // 업로드 파일
		public int getInquirySeq() {
			return inquirySeq;
		}
		public void setInquirySeq(int inquirySeq) {
			this.inquirySeq = inquirySeq;
		}
		public String getUserID() {
			return userID;
		}
		public void setUserID(String userID) {
			this.userID = userID;
		}
		public int getInquiryCnt() {
			return inquiryCnt;
		}
		public void setInquiryCnt(int inquiryCnt) {
			this.inquiryCnt = inquiryCnt;
		}
		public String getInquiryTitle() {
			return inquiryTitle;
		}
		public void setInquiryTitle(String inquiryTitle) {
			this.inquiryTitle = inquiryTitle;
		}
		public String getInquiryContent() {
			return inquiryContent;
		}
		public void setInquiryContent(String inquiryContent) {
			this.inquiryContent = inquiryContent;
		}
		public String getInquiryStat() {
			return inquiryStat;
		}
		public void setInquiryStat(String inquiryStat) {
			this.inquiryStat = inquiryStat;
		}
		public String getInquiryCate() {
			return inquiryCate;
		}
		public void setInquiryCate(String inquiryCate) {
			this.inquiryCate = inquiryCate;
		}
		public int getInquiryParent() {
			return inquiryParent;
		}
		public void setInquiryParent(int inquiryParent) {
			this.inquiryParent = inquiryParent;
		}
		public int getInquiryDepth() {
			return inquiryDepth;
		}
		public void setInquiryDepth(int inquiryDepth) {
			this.inquiryDepth = inquiryDepth;
		}
		public String getInquiryRegDate() {
			return inquiryRegDate;
		}
		public void setInquiryRegDate(String inquiryRegDate) {
			this.inquiryRegDate = inquiryRegDate;
		}
		public String getInquiryUpDate() {
			return inquiryUpDate;
		}
		public void setInquiryUpDate(String inquiryUpDate) {
			this.inquiryUpDate = inquiryUpDate;
		}
		public List<MultipartFile> getInquiryFile() {
			return inquiryFile;
		}
		public void setInquiryFile(List<MultipartFile> inquiryFile) {
			this.inquiryFile = inquiryFile;
		}
	    
	    
	    
}
