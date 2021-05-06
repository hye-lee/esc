package com.pro.esc.mypage.dao;

public class MyOrderDTO {
	
	private String ordSeq;
	private String userID;
	private String ordDate;
	private int proSeq;
	private int proPrice;
	private String proName;
	private String proBrand;
	private int proCateSeq;
	private int sizeSeq;
	private char proStat;
	private String proImgPath;
	

	private String recUser;
	private String recPhone;
	private String recAddr;
	private String recPostCode;
	private int ordTotal;
	private String ordVoice;
	private int ordDelivery;
	private String recExAddr;
	private String ordPayment;
	
	
	public String getRecUser() {
		return recUser;
	}
	public void setRecUser(String recUser) {
		this.recUser = recUser;
	}
	public String getRecPhone() {
		return recPhone;
	}
	public void setRecPhone(String recPhone) {
		this.recPhone = recPhone;
	}
	public String getRecAddr() {
		return recAddr;
	}
	public void setRecAddr(String recAddr) {
		this.recAddr = recAddr;
	}
	public String getRecPostCode() {
		return recPostCode;
	}
	public void setRecPostCode(String recPostCode) {
		this.recPostCode = recPostCode;
	}
	public int getOrdTotal() {
		return ordTotal;
	}
	public void setOrdTotal(int ordTotal) {
		this.ordTotal = ordTotal;
	}
	public String getOrdVoice() {
		return ordVoice;
	}
	public void setOrdVoice(String ordVoice) {
		this.ordVoice = ordVoice;
	}
	public int getOrdDelivery() {
		return ordDelivery;
	}
	public void setOrdDelivery(int ordDelivery) {
		this.ordDelivery = ordDelivery;
	}
	public String getRecExAddr() {
		return recExAddr;
	}
	public void setRecExAddr(String recExAddr) {
		this.recExAddr = recExAddr;
	}
	public String getOrdPayment() {
		return ordPayment;
	}
	public void setOrdPayment(String ordPayment) {
		this.ordPayment = ordPayment;
	}

	public String getOrdSeq() {
		return ordSeq;
	}
	public void setOrdSeq(String ordSeq) {
		this.ordSeq = ordSeq;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}
	public int getProSeq() {
		return proSeq;
	}
	public void setProSeq(int proSeq) {
		this.proSeq = proSeq;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProBrand() {
		return proBrand;
	}
	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}
	public int getProCateSeq() {
		return proCateSeq;
	}
	public void setProCateSeq(int proCateSeq) {
		this.proCateSeq = proCateSeq;
	}
	public int getSizeSeq() {
		return sizeSeq;
	}
	public void setSizeSeq(int sizeSeq) {
		this.sizeSeq = sizeSeq;
	}
	public char getProStat() {
		return proStat;
	}
	public void setProStat(char proStat) {
		this.proStat = proStat;
	}
	public String getProImgPath() {
		return proImgPath;
	}
	public void setProImgPath(String proImgPath) {
		this.proImgPath = proImgPath;
	}


}
