package org.doit.ky.domain;

import lombok.Data;

@Data
public class PageDTO {

	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;

	private int total;
	private Criteria criteria;

	public PageDTO(Criteria criteria, int total) {
		this.criteria = criteria;
		this.total = total;

		this.endPage = (int)(Math.ceil(criteria.getPageNum()/
				(double)criteria.getAmount())) * criteria.getAmount();
		this.startPage = this.endPage - criteria.getAmount() + 1;

		int realEndPage = (int)(Math.ceil((double)total/criteria.getAmount()));
		if(realEndPage < this.endPage) this.endPage = realEndPage;

		this.prev = this.startPage > 1;
		this.next = this.endPage < realEndPage;
	}
}
