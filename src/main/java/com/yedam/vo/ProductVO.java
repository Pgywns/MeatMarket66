package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ProductVO {
	
	private int prdNo;
	private String prdName;
	private String prdImage;
	private String prdContent;
	private int prdPrice;
	private String prdSort;
	private Date prdDate;
	private int prdCount;
		
}
