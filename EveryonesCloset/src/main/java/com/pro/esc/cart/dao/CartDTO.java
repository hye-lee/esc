package com.pro.esc.cart.dao;

public class CartDTO {
	
	private int cartSeq;
	private String userID;
	private int proSeq;
	private String proName;
	private int proPrice;
	private String proImgPath;
	private String proBrand;
	
	
	
	public String getProImgPath() {
		return proImgPath;
	}
	public void setProImgPath(String proImgPath) {
		this.proImgPath = proImgPath;
	}
	public String getProBrand() {
		return proBrand;
	}
	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}
	public int getCartSeq() {
		return cartSeq;
	}
	public void setCartSeq(int cartSeq) {
		this.cartSeq = cartSeq;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getProSeq() {
		return proSeq;
	}
	public void setProSeq(int proSeq) {
		this.proSeq = proSeq;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	

}
