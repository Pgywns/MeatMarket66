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
		String prdNo = req.getParameter("prdNo");
		
		req.setAttribute("prdSort", prdSort);
		req.setAttribute("prdImage", prdImage);
		req.setAttribute("prdName", prdName);
		req.setAttribute("prdPrice", prdPrice);
		req.setAttribute("prdContent", prdContent);
		req.setAttribute("prdNo", prdNo);
		
		req.getRequestDispatcher("product/productDetail.tiles").forward(req, resp);
	}

}
