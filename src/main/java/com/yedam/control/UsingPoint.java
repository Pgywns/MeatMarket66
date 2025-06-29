package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.PointService;
import com.yedam.service.PointServiceImpl;

public class UsingPoint implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		
		int usingPoint = Integer.parseInt(req.getParameter("usingPoint")); 
		usingPoint = (-1) * usingPoint;
		
		if(usingPoint != 0) {
		PointService svc = new PointServiceImpl(); 
		svc.usingPoint(userId, usingPoint);
		}
	}

}
