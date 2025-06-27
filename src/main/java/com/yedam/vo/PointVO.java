package com.yedam.vo;

import lombok.Data;
import oracle.sql.DATE;

@Data
public class PointVO {
	private String userId;
	private int point;
	private DATE odDate;
}
