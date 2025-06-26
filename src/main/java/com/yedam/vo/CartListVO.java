package com.yedam.vo;

import lombok.Data;

@Data
public class CartListVO { //상품테이블: 이미지, 상품명, 가격, 코드 장바구니테이블: 코드, 아이디, 수량, 
	//장바구니
	private String userId;
	private int prdNo;
	private int cartQty;
	//상품
	private String prdName;
	private String prdImage;
	private int prdPrice;
}
