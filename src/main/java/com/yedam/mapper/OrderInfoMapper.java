package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.OrderInfoVO;

public interface OrderInfoMapper {
	// 주문 조회
	public List<OrderInfoVO> selectOrderInfo(int odNo);

}
