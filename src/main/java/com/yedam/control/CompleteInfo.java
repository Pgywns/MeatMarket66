package com.yedam.control;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.AddressService;
import com.yedam.service.AddressServiceImpl;
import com.yedam.service.CompleteService;
import com.yedam.service.CompleteServiceImpl;
import com.yedam.service.PointService;
import com.yedam.service.PointServiceImpl;
import com.yedam.vo.AddressVO;
import com.yedam.vo.OrderVO;

public class CompleteInfo implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//주문정보 (주문일, 받는사람, 주소, 연락처, 잔여적립금, 결제금액) 
		resp.setContentType("text/json;charset=utf-8");	
		
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("userId");
		
		//(주문일, 받는사람, 연락처, 결제음액, 주소코드) userId로 최신의 주문서쿼리 order by OrderVo로 받아오면됨.
		CompleteService completeSvc = new CompleteServiceImpl();
		
		OrderVO orderInfo = completeSvc.orderInfo(userId);
		
		Date orderDate = orderInfo.getOdDate();
		String reciveName = orderInfo.getOdName();
		String phone = orderInfo.getPhone();
		int amount = orderInfo.getAmount();
		int addrNo = orderInfo.getAddrNo();
		
		//(배송지) -> addrNo쿼리
		AddressService addrSvc = new AddressServiceImpl();
		AddressVO orderAddr = addrSvc.selectAddrBySeq(addrNo);
		
		//(현재포인트)
		PointService pointSvc = new PointServiceImpl();
		int myPoint = pointSvc.totalPoint(userId);
		
		//개별 결과를 한꺼번에 map에 담기
		Map<String, Object> completInfo = new HashMap<>();
		completInfo.put("orderDate", orderDate);
		completInfo.put("reciveName", reciveName);
		completInfo.put("phone", phone);
		completInfo.put("amount", amount);
		completInfo.put("address", orderAddr);
		completInfo.put("point", myPoint);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(completInfo);
		
		resp.getWriter().print(json);
		
	}

}
