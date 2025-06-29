package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class FindIdControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		
		MemberService svc = new MemberServiceImpl();
		
		String userId = svc.findId(name, phone);
		
		if (userId != null) {
			resp.getWriter().print("{\"retCode\":\"Success\", \"userId\":\"" + userId + "\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"Failure\"}");
		}
	
	}

}
