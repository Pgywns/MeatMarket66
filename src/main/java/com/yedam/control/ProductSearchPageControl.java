package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;

public class ProductSearchPageControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		String keyword = req.getParameter("keyword");
		ProductService svc = new ProductServiceImpl();
		int totalCnt = svc.productSearchPage(keyword);
		
		resp.getWriter().print("{\"totalCnt\": " + totalCnt + "}");

	}

}
