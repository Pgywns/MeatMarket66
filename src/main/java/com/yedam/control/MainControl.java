package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MainService;
import com.yedam.service.MainServiceImpl;
import com.yedam.vo.ProductVO;
import com.yedam.vo.ReviewVO;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 인기상품
		MainService svc = new MainServiceImpl();
		List<ProductVO> list = svc.hotProductList();
		req.setAttribute("Hlist", list);
		
		// 리뷰 목록
		List<ReviewVO> listR = svc.mainReview();
		
		// Image가 null일 경우
		for(ReviewVO review : listR) {
			if(review.getRvwImage() == null || review.getRvwImage().isEmpty()) {
				review.setRvwImage("보노보노.png");
			}
		}
		
		req.setAttribute("Rlist", listR);
		
		String auth = null;
		HttpSession session = req.getSession();
		if (session.getAttribute("auth") != null) {
			auth = (String) session.getAttribute("auth");			
		}
		
		if (auth == null || auth.equals("user")) {
			req.getRequestDispatcher("user/main.tiles").forward(req, resp);
		} else if (auth != null || auth.equals("admin")) {
			req.getRequestDispatcher("admin/main.tiles").forward(req, resp);
		}
	}

}
