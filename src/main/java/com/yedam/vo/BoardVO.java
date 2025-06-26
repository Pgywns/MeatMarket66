package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int boardNo;
	private String userId;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private String boardCategory;
	private String answer;
}
