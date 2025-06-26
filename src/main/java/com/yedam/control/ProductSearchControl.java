package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;

public class ProductSearchControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		
		String keyword = req.getParameter("keyword");
		
		ProductService svc = new ProductServiceImpl();
		List<ProductVO> list =svc.productSearch(keyword);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);
		resp.getWriter().print(json);
		System.out.println(json);
	}

}
