package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.CartService;
import com.yedam.service.CartServiceImpl;
import com.yedam.vo.CartListVO;

public class CartControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");	
		
		//세선에서 아이디 요청
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("userId");
		
		//장바구니목록출력 DB query
		CartService svc = new CartServiceImpl();
		List<CartListVO> cartList = svc.cartList(userId);	//세션아이디 받기	
		
		//json으로 변환
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(cartList);
		
		//데이터전달
		resp.getWriter().print(json);		
	
	}	
}
