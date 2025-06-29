package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;

public class ProductPageControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductService svc = new ProductServiceImpl();
		int totalCnt = svc.productPage();
		
		resp.getWriter().print("{\"totalCnt\": " + totalCnt + "}");
	}

}
