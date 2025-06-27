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

public class DeleteAddressControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		String addrNo = req.getParameter("addrNo");

		AddressVO addr = new AddressVO();
		addr.setUserId(userId);
		addr.setAddrNo(Integer.parseInt(addrNo));
		
		AddressService svc = new AddressServiceImpl();
		
		if (svc.deleteAddress(addr)) {
			resp.getWriter().print("{\"retCode\":\"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"Failure\"}");
		}
	}

}
