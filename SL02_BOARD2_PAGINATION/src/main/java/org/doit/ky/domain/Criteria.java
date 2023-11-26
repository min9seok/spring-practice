package org.doit.ky.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	private int pageNum;
	private int amount;
	public Criteria() {
		this(1,5);	
	}	
	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
	// ?pageNum=1&amount=10&type=T&keyword=홍길동
	   public String getListLink() {
	      UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
	            .queryParam("pageNum", this.getPageNum())
	            .queryParam("amount", this.getAmount());
	      //.queryParam("type", this.getPageNum())
	      //.queryParam("keyword", this.getPageNum())
	      return builder.toUriString();
	   }	
}
