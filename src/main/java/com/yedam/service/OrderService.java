package com.yedam.service;

import java.util.List;

import com.yedam.vo.AddressVO;
import com.yedam.vo.OrderVO;

public interface OrderService {
	//기본배송지조회
	public List<AddressVO> findAddress(String userId);
	public boolean submitOrderForm(OrderVO form);
}
