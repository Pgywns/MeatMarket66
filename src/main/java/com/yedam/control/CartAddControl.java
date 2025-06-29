package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.CartService;
import com.yedam.service.CartServiceImpl;
import com.yedam.vo.CartVO;

public class CartAddControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("utf-8");

		// session에서 로그인 정보가져오기
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		String auth = (String) session.getAttribute("auth");
		
		if (auth == null) {
			resp.getWriter().print("{\"retCode\":\"guest\"}");
			return;
		} else if (auth.equals("admin")) {
			resp.getWriter().print("{\"retCode\":\"admin\"}");
			return;
		} 
		
		// 파라미터 불러오기
		String prdNo = req.getParameter("prdNo");
		String cartQty = req.getParameter("cartQty");

		// 파라미터 값을 db로
		CartVO cart = new CartVO();
		cart.setCartQty(Integer.parseInt(cartQty));
		cart.setPrdNo(Integer.parseInt(prdNo));
		cart.setUserId(userId);
		
		CartService svc = new CartServiceImpl();

		if (svc.addCart(cart)) {
			resp.getWriter().print("{\"retCode\":\"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}
	}

}
