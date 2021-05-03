package com.pro.esc.order.dao;

public class OrderDTO {
	
	/*주문번호(PK)	ordSeq(PK)	INTEGER	NOT NULL
	아이디(FK)	userID(FK)	VARCHAR(20)	NOT NULL
	주문일	ordDate	TIMESTAMP	NULL
	수령자	recUser	VARCHAR(10)	NULL
	수령연락처	recPhone	VARCHAR(15)	NULL
	수령주소	recAddr	VARCHAR(50)	NULL
	수령기타주소	recExAddr	VARCHAR(20)	NULL
	수령자우편번호	recPostCode	VARCHAR(10)	NULL
	주문총금액	ordTotal	INTEGER	NULL
	결제수단	ordPayment	VARCHAR(5)	NULL
	송장번호	ordVoice	VARCHAR(10)	NULL
	배송비	ordDelivery	INTEGER	NULL
*/
	
	private String ordSeq;
	private String userID;
	private String ordDate;
	private String recUser;
	private String recPhone;
	private String recAddr;
	private String recPostCode;
	private int ordTotal;
	private String ordVoice;
	private int ordDelivery;
	private String recExAddr;
	private String ordPayment;
	
	//페이징
    private int startIndex;
    private int cntPerPage;
	
	
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getCntPerPage() {
		return cntPerPage;
	}
	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}
	public String getOrdPayment() {
		return ordPayment;
	}
	public void setOrdPayment(String ordPayment) {
		this.ordPayment = ordPayment;
	}
	public String getRecExAddr() {
		return recExAddr;
	}
	public void setRecExAddr(String recExAddr) {
		this.recExAddr = recExAddr;
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
	
	
	
	
}

