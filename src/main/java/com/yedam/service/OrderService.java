package com.yedam.service;

import java.util.List;

import com.yedam.vo.AddressVO;
import com.yedam.vo.CartVO;
import com.yedam.vo.OrderVO;

public interface OrderService {
	//기본배송지조회
	public List<AddressVO> findAddress(String userId);
	//주문등록
	public boolean submitOrderForm(OrderVO form);
	//주문번호출력
	public int returnOrderNo(String userId);
	//주문상품목록출력
	public List<CartVO> OrderList(String userId);
	//상세주문등록
	public boolean sumitOrderInfo(int odNo, int prdNo, int orderQty);
	public boolean outStock(int prdNo, int orderQty);
	
	// 내 아이디 주문 카운트
	public int selectOrderCount(String id);
	// 내 아이디 주문 조회
	public List<OrderVO> selectUserOrder(String id);
}
