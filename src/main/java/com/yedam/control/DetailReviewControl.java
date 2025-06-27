package com.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReviewService;
import com.yedam.service.ReviewServiceImpl;
import com.yedam.vo.ReviewVO;

public class DetailReviewControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		ReviewService svc = new ReviewServiceImpl();
		
		String prdNo = req.getParameter("prdNo");
		
		List<ReviewVO> list = svc.rvwList(Integer.parseInt(prdNo));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);
		
		PrintWriter out = resp.getWriter();
		out.print(json);
	}

}
