package com.pro.esc.inquiry.dao;

public class PageDto {
	
	private Integer rowCount=10; 	//페이지당 글 갯수
	private Integer colBlock=5; 	//블럭당 페이지수
	private Integer total; 		//전체 글 갯수
	private Integer totalPage; 	//전체 페이지수
	private Integer totalBlock; //전체 블럭수
	private Integer page=1; 		//현재페이지
	private Integer block=1; 		//현재블럭
	private Integer startInx=0; //시작인덱스
	private Integer startPage=1; //시작페이지
	private Integer endPage=1;    //끝 페이지
	private Integer pre;       //이전페이지
	private Integer next;		//다음페이지
	
	public PageDto(int count, int page) {
		setPage(page); //현재페이지
		setTotal(count); //총 게시물수
		setTotalPage(count); //총 페이지수
		setTotalBlock(totalPage); //총 블럭수
		blockSetting(page);
		
		setStartInx(page); //DB질의를 위한 설정
	
	}
	
	public void blockSetting(int page){
		setBlock(page);
		this.startPage= (block-1)*colBlock+1;
		this.endPage=startPage+colBlock-1;
		
		if(endPage>totalPage) {
			this.endPage=totalPage;
		}
		
		this.pre=page-1;
		this.next=page+1;
	
	}
	
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public Integer getColBlock() {
		return colBlock;
	}
	public void setColBlock(Integer colBlock) {
		this.colBlock = colBlock;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int total) { //총 페이지수
		this.totalPage = (int)Math.ceil(total*1.0/rowCount); 
	}
	public Integer getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalPage) { //총 블럭수
		this.totalBlock = (int)Math.ceil(totalPage*1.0/colBlock);
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getBlock() {
		return block;
	}
	public void setBlock(int page) {
		this.block = (int)((page-1)/colBlock)+1;
	}
	public Integer getStartInx() {
		return startInx;
	}
	public void setStartInx(int page) { //각 페이지마다 시작하는 글 인덱스
		this.startInx = (page-1)*rowCount;
	}
	public Integer getStartPage() {
		return startPage;
	}
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}
	public Integer getEndPage() {
		return endPage;
	}
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
	public Integer getPre() {
		return pre;
	}
	public void setPre(Integer pre) {
		this.pre = pre;
	}
	public Integer getNext() {
		return next;
	}
	public void setNext(Integer next) {
		this.next = next;
	}
	
	
	

}
