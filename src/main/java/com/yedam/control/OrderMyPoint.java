package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.PointService;
import com.yedam.service.PointServiceImpl;

public class OrderMyPoint implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		
		PointService psv = new PointServiceImpl();
		int totalPoint = psv.totalPoint(userId);
		
		System.out.println(totalPoint);
		resp.getWriter().print(totalPoint);
	}

}
