package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.common.SearchDTO;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;

public class ProductOptionControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		
		String page = req.getParameter("page");
		String order = req.getParameter("order");
		String prdSort = req.getParameter("prdSort");
		
		
		SearchDTO search = new SearchDTO();
		search.setOrder(order);
		search.setPage(Integer.parseInt(page));
		search.setPrdSort(prdSort);
		
		ProductService svc = new ProductServiceImpl();
		List<ProductVO> list = svc.productOption(search);
		
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);
		resp.getWriter().print(json);
		
		
	}

}
