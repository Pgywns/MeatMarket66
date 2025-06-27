package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.CartService;
import com.yedam.service.CartServiceImpl;
import com.yedam.vo.CartVO;

public class CartAddControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		
		String userId =req.getParameter("userId");
		String prdNo = req.getParameter("prdNo");
		String cartQty = req.getParameter("cartQty");
		
	
		
		CartVO cart = new CartVO();
		cart.setCartQty(Integer.parseInt(cartQty));
		cart.setPrdNo(Integer.parseInt(prdNo));
		cart.setUserId(userId);
		System.out.println(cart.getUserId()); 
		CartService svc = new CartServiceImpl();
		
		if(svc.addCart(cart)) {
			System.out.println("등록 성공");
		} else {
			System.out.println("등록 실패");
		}
	}

}
