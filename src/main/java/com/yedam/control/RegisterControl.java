package com.yedam.control;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.AddressService;
import com.yedam.service.AddressServiceImpl;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.AddressVO;
import com.yedam.vo.MemberVO;

public class RegisterControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		if (req.getMethod().equals("GET")) {			
			req.getRequestDispatcher("member/member.tiles").forward(req, resp);
		} else if (req.getMethod().equals("POST")) {
			String name = req.getParameter("userName");
			String id = req.getParameter("userId");
			String password = req.getParameter("pw");
			String phone = req.getParameter("userPhone");
			String zipCode = req.getParameter("zipCode"); 
			String addOne = req.getParameter("addOne");
			String addTwo = req.getParameter("addTwo");
			
			MemberVO member = new MemberVO();
			member.setUserName(name);
			member.setUserId(id);
			member.setUserPw(password);
			member.setUserPhone(phone);
			
			AddressVO add = new AddressVO();
			add.setUserId(id);
			add.setZipCode(Integer.parseInt(zipCode));
			add.setAddrOne(addOne);
			add.setAddrTwo(addTwo);
			add.setAddrName("기본");
			add.setFirstAddr("true");
			
			MemberService msv = new MemberServiceImpl();
			AddressService asv = new AddressServiceImpl();
			
			
			if (msv.insertMember(member) && asv.insertAdd(add)) {
				resp.sendRedirect("login.do");
			} 
		}
	}

}
