package com.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.OrderInfoService;
import com.yedam.service.OrderInfoServiceImpl;
import com.yedam.service.OrderService;
import com.yedam.service.OrderServiceImpl;
import com.yedam.service.ReviewService;
import com.yedam.service.ReviewServiceImpl;
import com.yedam.vo.OrderInfoVO;
import com.yedam.vo.OrderVO;
import com.yedam.vo.ReviewVO;

public class SelectOrderInfoControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
	    resp.setContentType("application/json;charset=utf-8"); // ← 'application/json'이 표준

	    HttpSession session = req.getSession();
	    String userId = (String) session.getAttribute("userId");

	    OrderService ovc = new OrderServiceImpl();
	    List<OrderVO> orderList = ovc.selectUserOrder(userId);
	    if (orderList == null) orderList = new ArrayList<>();

	    OrderInfoService svc = new OrderInfoServiceImpl();
	    ReviewService rvc = new ReviewServiceImpl();
	    List<OrderInfoVO> list = new ArrayList<>();

	    ReviewVO review = new ReviewVO();
	    review.setUserId(userId);
	    
	    for (OrderVO order : orderList) {
	        int odNo = order.getOdNo();
	        System.out.println("odNo:" + odNo);
	        List<OrderInfoVO> tempList = svc.orderInfoList(odNo);
	        System.out.println("tmepList: " + tempList);
	        if (tempList != null) {
	            list.addAll(tempList);
	        }
	    }

	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(list);

	    PrintWriter out = resp.getWriter();
	    out.print(json);
	}

}
