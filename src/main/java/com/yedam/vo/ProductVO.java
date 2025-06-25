package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ProductVO {
	
	private int pNo;
	private String pName;
	private String pImage;
	private String pContent;
	private int price;
	private String pSort;
	private Date pDate;
	private int pCount;
		
}
