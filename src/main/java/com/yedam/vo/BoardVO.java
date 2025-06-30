package com.yedam.vo;

import lombok.Data;

@Data
public class BoardVO {
	private int boardNo;
	private String userId;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	private String boardCategory;
	private String answer;
}
