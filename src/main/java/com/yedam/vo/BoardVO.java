package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int bNo;
	private String uId;
	private String bTitle;
	private String bContent;
	private Date bDate;
	private String bCategory;
	private String answer;
}
