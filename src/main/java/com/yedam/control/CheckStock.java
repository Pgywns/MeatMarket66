package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;

public class CheckStock implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		String auth = (String) session.getAttribute("auth");
		
		if (auth == null) {
			resp.getWriter().print("guest");
			return;
		} else if (auth.equals("admin")) {
			resp.getWriter().print("admin");
			return;
		}
		
		int prdNo = Integer.parseInt(req.getParameter("prdNo")); 
		
		ProductService svc = new ProductServiceImpl();
		int stock =  svc.checkStockByPrdNO(prdNo);
		
		resp.getWriter().print(stock);
		
	}

}
