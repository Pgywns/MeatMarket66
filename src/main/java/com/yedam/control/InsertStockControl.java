package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;
import com.yedam.vo.StockVO;

public class InsertStockControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prdNo = req.getParameter("prdNo");
		String prdStock = req.getParameter("prdStock");
		
		ProductService svc = new ProductServiceImpl();
		
		StockVO stock = new StockVO();
		stock.setPrdNo(Integer.parseInt(prdNo));
		stock.setPrdStock(Integer.parseInt(prdStock));
		
		if (svc.insertStock(stock)) {
			resp.getWriter().print("{\"retCode\":\"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}
	}

}
