package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class ProductDetailControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prdSort = req.getParameter("prdSort");
		String prdImage = req.getParameter("prdImage");
		String prdName = req.getParameter("prdName");
		String prdPrice = req.getParameter("prdPrice");
		String prdContent = req.getParameter("prdContent");
		
		System.out.println(prdSort);
		System.out.println(prdImage);
		System.out.println(prdName);
		System.out.println(prdPrice);
		System.out.println(prdContent);
		
		req.getRequestDispatcher("product/productDetail.tiles").forward(req, resp);
	}

}
