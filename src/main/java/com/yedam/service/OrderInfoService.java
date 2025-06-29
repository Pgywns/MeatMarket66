package com.yedam.service;

import java.util.List;

import com.yedam.vo.OrderInfoVO;

public interface OrderInfoService {
	// 상품조회
	public List<OrderInfoVO> orderInfoList(int odNo);
}