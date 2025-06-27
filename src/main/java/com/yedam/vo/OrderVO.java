package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class OrderVO {
	private int odNo;
	private String userId;
	private int addrNo;
	private Date odDate;
	private int amount;
	private String odName;
	private String phone;
}
