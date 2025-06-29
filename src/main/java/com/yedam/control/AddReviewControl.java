package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.ReviewService;
import com.yedam.service.ReviewServiceImpl;
import com.yedam.vo.ReviewVO;

public class AddReviewControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		
		String path = req.getServletContext().getRealPath("img/review");

		MultipartRequest mr = new MultipartRequest(
			req,
			path,
			1024 * 1024 * 5,
			"UTF-8",
			new DefaultFileRenamePolicy()
		);

		String prdNo = mr.getParameter("prdNo");
		String prdName = mr.getParameter("prdName");
		String userName = mr.getParameter("userName");
		String content = mr.getParameter("content");
		String prdImage = mr.getFilesystemName("prdImage");
		
		
		java.io.File folder = new java.io.File(path);
	    if (!folder.exists()) {
	        folder.mkdirs();
	    }
  
	    java.io.File oldFile = new java.io.File(path, prdImage);
	    java.io.File newFile = new java.io.File(path, prdImage);
	    oldFile.renameTo(newFile);
	    
	    ReviewVO review = new ReviewVO();
	    
	    review.setPrdNo(Integer.parseInt(prdNo));
		review.setPrdName(prdName);
		review.setUserId(userId);
		review.setRvwContent(content);
		review.setRvwImage(prdImage);
		
		ReviewService svc = new ReviewServiceImpl();
		
		if (svc.addReview(review)) {
			req.getRequestDispatcher("member/myPage.tiles").forward(req, resp);
		}
	}

}
