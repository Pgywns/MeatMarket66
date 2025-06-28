package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.CompleteService;
import com.yedam.service.CompleteServiceImpl;
import com.yedam.service.OrderService;
import com.yedam.service.OrderServiceImpl;
import com.yedam.vo.CompleteListVO;

public class CompleteList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");	
		
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("userId");
		
		//가장 최근주문번호 출력
		OrderService orderScv = new OrderServiceImpl();
		int odNo = orderScv.returnOrderNo(userId); 
		
		//최근번호기반 상세주문 join 상품테이블 결과 cartVO
		CompleteService svc = new CompleteServiceImpl();
		List<CompleteListVO> completeList = svc.CompleteList(odNo);
		
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(completeList);
		
		//데이터전달
		resp.getWriter().print(json);	
	}

}
