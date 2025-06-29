package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.AddressService;
import com.yedam.service.AddressServiceImpl;

public class ChangeFalseControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		
		AddressService svc = new AddressServiceImpl();
		
		if (svc.firstAddrChangeFalse(userId)) {
			resp.getWriter().print("{\"retCode\":\"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"Failure\"}");
		}

	}

}
