package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReviewService;
import com.yedam.service.ReviewServiceImpl;
import com.yedam.vo.ReviewVO;

public class ReviewListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		//아이디요청 가져옴 review insert할때
		//HttpSession session = req.getSession();
		//String userId = (String)session.getAttribute("userId");
		int prdNo = 1;
		//int prdNo = Integer.parseInt(req.getParameter("prdNo"));
		ReviewVO rvo = new ReviewVO();
		rvo.setPrdNo(prdNo);
		System.out.println(rvo);
		ReviewService svc = new ReviewServiceImpl();
		List<ReviewVO> list = svc.rvwList(prdNo);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);
		resp.getWriter().print(json);
		System.out.println(json);
	}

}
