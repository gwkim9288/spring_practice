package com.gwkim.posting.domain;

/**
 *
 */
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev,next;
	private int total;
	private Criteria cri;
	private int realEnd;
	
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)Math.ceil(this.cri.getPageNum()*1.0/this.cri.getAmount())*this.cri.getAmount();
		
		this.startPage = endPage-9;
		
		this.prev = startPage>1;
		
		realEnd = (int) Math.ceil(total*1.0/this.cri.getAmount());
		
		if(realEnd<this.endPage)
			this.endPage = realEnd;
		
		this.next = endPage < realEnd;

	}
}
