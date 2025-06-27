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

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		if (req.getMethod().equals("GET")) {			
			req.getRequestDispatcher("member/member.tiles").forward(req, resp);
		} else if (req.getMethod().equals("POST")) {
			String id = req.getParameter("userId");
			String pw = req.getParameter("userPw");
			
			MemberService svc = new MemberServiceImpl();
			MemberVO member = svc.login(id, pw);
			
			if (member != null) {
				HttpSession session = req.getSession();
				session.setAttribute("userId", member.getUserId());
				session.setAttribute("userName", member.getUserName());
				session.setAttribute("auth", member.getUserRes());
				
				if (member.getUserRes().equals("user")) {
					resp.sendRedirect("main.do");
				} else if (member.getUserRes().equals("admin")) {
					resp.sendRedirect("main.do");
				}
			} else {
				req.setAttribute("msg", "아이디와 비밀번호를 확인하세요.");
				req.getRequestDispatcher("member/member.tiles").forward(req, resp);
			}
		}

	}

}
