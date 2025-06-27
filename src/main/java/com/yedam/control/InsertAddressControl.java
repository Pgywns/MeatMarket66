package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.AddressService;
import com.yedam.service.AddressServiceImpl;
import com.yedam.vo.AddressVO;

public class InsertAddressControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		String zipCode = req.getParameter("zipCode");
		String addrOne = req.getParameter("addrOne");
		String addrTwo = req.getParameter("addrTwo");
		String addrName = req.getParameter("addrName");

		AddressVO add = new AddressVO();
		add.setUserId(userId);
		add.setZipCode(Integer.parseInt(zipCode));
		add.setAddrOne(addrOne);
		add.setAddrTwo(addrTwo);
		add.setAddrName(addrName);
		add.setFirstAddr("false");
		
		AddressService svc = new AddressServiceImpl();
		
		if (svc.insertAdd(add)) {
			resp.getWriter().print("{\"retCode\":\"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"Failure\"}");
		}
	}

}
