package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.OrderService;
import com.yedam.service.OrderServiceImpl;
import com.yedam.vo.CartVO;
import com.yedam.vo.OrderVO;

public class SubmitOrderForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		
		//주소록 반영위해 주소코드로 가지고 오기떄문에 파라미터 활용
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		int amount = Integer.parseInt(req.getParameter("amount"));
		int addrNo = Integer.parseInt(req.getParameter("addr"));
		
		OrderVO form = new OrderVO ();
		
		form.setUserId(userId);
		form.setAddrNo(addrNo);
		form.setOdName(name);
		form.setPhone(phone);
		form.setAmount(amount);
		
		OrderService svc = new OrderServiceImpl();
		//주문서등록
		svc.submitOrderForm(form);
		//주문번호
		int odNo = svc.returnOrderNo(userId);
		//장바구니목록
		List<CartVO> orderList = svc.OrderList(userId);
		//주문상세 상품담기
		for(CartVO item:orderList) {
			int prdNo = item.getPrdNo();
			int orderQty = item.getCartQty();
			//상세주문T등록
			svc.sumitOrderInfo(odNo, prdNo, orderQty);
			//재고테이블 반영
			orderQty = (-1) * orderQty;
			svc.outStock(prdNo, orderQty);
			//포인트 차감
			//포인트 적립
			
		}
		
		
		
		
		//1차 주문서테이블 insert
		//2차 주문서T에서 주문번호 가지고 오기 -최신걸로 조회하는 쿼리
		//3차 장바구니 가지고오기
		//4차 주문번호 + 장바구니 상품으로 insert하는데 상품:수량 * for문
		//5차 출고반영 
		//포인트 차감
		//포인트 적림

	}

}
