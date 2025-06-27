package com.yedam.vo;

import java.util.Date;

import lombok.Data;
@Data
public class ReviewVO {
	private int prdNo;
	private String userId;
	private int rvwNo;
	private String rvwContent;
	private String rvwImage;
	private Date rvwDate;
	private String prdName;
}
