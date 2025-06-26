package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class FindPasswordControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		
		MemberService svc = new MemberServiceImpl();
		
		String password = svc.findPassword(id, name, phone);
		System.out.println(password);
		
		if (password != null) {
			resp.getWriter().print("{\"retCode\":\"Success\", \"userPassword\":\"" + password + "\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"Failure\"}");
		}
	}

}
