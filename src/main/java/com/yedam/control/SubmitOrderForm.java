package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;

public class SubmitOrderForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		
		//주소록 반영위해 주소코드로 가지고 옴. 
		
		//1차 주문서테이블 insert
		//2차 주문서T에서 주문번호 가지고 오기 -최신걸로 조회하는 쿼리
		//3차 장바구니 가지고오기
		//4차 주문번호 + 장바구니 상품으로 insert하는데 상품:수량 * for문
		//5차
		//포인트 차감
		//포인트 적림

	}

}
