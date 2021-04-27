package com.pro.esc.order.dao;

public class OrderProductDTO {
	
	/*order_Product
	주문상품번호(PK)	orProSeq(PK)	INTEGER	NOT NULL
	주문번호(FK)	ordSeq(FK)	INTEGER	NULL
	상품번호(FK)	proSeq(FK)	INTEGER	NULL*/
	
	private int orProSeq;
	private String ordSeq;
	private int proSeq;
	
	public int getOrProSeq() {
		return orProSeq;
	}
	public void setOrProSeq(int orProSeq) {
		this.orProSeq = orProSeq;
	}
	public String getOrdSeq() {
		return ordSeq;
	}
	public void setOrdSeq(String ordSeq) {
		this.ordSeq = ordSeq;
	}
	public int getProSeq() {
		return proSeq;
	}
	
	public void setProSeq(int proSeq) {
		this.proSeq=proSeq;
	}
	
	

}
