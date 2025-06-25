package com.yedam.common;

import lombok.Data;

@Data
public class SearchDTO {
	int page;
	String searchCondition;
	String keyword;
}
