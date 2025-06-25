package com.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.CartService;
import com.yedam.service.CartServiceImpl;
import com.yedam.vo.CartVO;

public class CartControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("이거되나???");
		resp.setContentType("text/json;charset=utf-8");	
		
		//세선에서 아이디 요청
		//HttpSession session = req.getSession();
		//String userId = session.getAttribute(""); 
		//세션으료 userid 가지고 와야함. boardListControl참고.
		//로그인control에서 session으로 전달하는 키값 가지고 와야함.
		
	
		String userId = "user01";
		
		//장바구니목록출력 DB query
		CartService svc = new CartServiceImpl();
		List<CartVO> cartList = svc.cartList(userId);		
		
		
		System.out.println(userId);
		
		for (CartVO cart : cartList) {
		    System.out.println(cart); // CartVO에 toString()이 구현되어 있어야 보기 좋게 출력됨
		}
		
		//json으로 변환
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(cartList);
		//데이터전달 & 이동
		resp.getWriter().print(json);		
			
	}	
}
