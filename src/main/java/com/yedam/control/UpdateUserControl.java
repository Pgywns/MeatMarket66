package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class UpdateUserControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		String userName = req.getParameter("userName");
		String userPw = req.getParameter("userPw");
		String userPhone = req.getParameter("userPhone");
		
		MemberVO member = new MemberVO();
		member.setUserId(userId);
		member.setUserName(userName);
		member.setUserPw(userPw);
		member.setUserPhone(userPhone);
		
		MemberService svc = new MemberServiceImpl();
		if (svc.updateUser(member)) {
			resp.getWriter().print("{\"retCode\":\"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"Failure\"}");
		}
		
	}

}
