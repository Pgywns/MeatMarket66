package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.BoardSevice;
import com.yedam.service.BoardSeviceImpl;
import com.yedam.service.OrderService;
import com.yedam.service.OrderServiceImpl;
import com.yedam.service.PointService;
import com.yedam.service.PointServiceImpl;
import com.yedam.service.ReviewService;
import com.yedam.service.ReviewServiceImpl;

public class MyPageControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		
		// 내 주문 조회
		OrderService osv = new OrderServiceImpl();
		int totalOrder = osv.selectOrderCount(userId);
		req.setAttribute("totalOrder", totalOrder);
		
		//리뷰 조회
		ReviewService rsv = new ReviewServiceImpl();
		int totalReview = rsv.totalReview(userId);
		req.setAttribute("totalReview", totalReview);
		
		// 적립금 조회
		PointService psv = new PointServiceImpl();
		int totalPoint = psv.totalPoint(userId);
		req.setAttribute("totalPoint", totalPoint);
		
		// 내 문의 조회
		BoardSevice bsv = new BoardSeviceImpl();
		int totalBoard = bsv.BoardToTalCount(userId);
		req.setAttribute("totalBoard", totalBoard);
		System.out.println(totalBoard);
		
		req.getRequestDispatcher("member/myPage.tiles").forward(req, resp);
	}

}
