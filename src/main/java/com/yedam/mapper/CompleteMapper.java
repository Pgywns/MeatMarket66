package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.CompleteListVO;
import com.yedam.vo.OrderVO;

public interface CompleteMapper {
	//주문정보
	public OrderVO selectOrderInfo(String userId);
	//주문완료상품리스트
	public List<CompleteListVO> selectCompleteList(int odNo);

}
