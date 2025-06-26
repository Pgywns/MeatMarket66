package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;

public class ProductListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		
		ProductService svc = new ProductServiceImpl();
		
		// 카테고리별 수량
		List<ProductVO> list = svc.productCount();
		
		req.setAttribute("cList", list);
		System.out.println(list);
		req.getRequestDispatcher("product/productList.tiles").forward(req, resp);
		
	}

}
