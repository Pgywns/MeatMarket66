package com.yedam.service;

import java.util.List;

import com.yedam.vo.CompleteListVO;
import com.yedam.vo.OrderVO;

public interface CompleteService {
	//완료된 주문정보
	public OrderVO orderInfo(String userId);
	//주몬완료 List.
	public List<CompleteListVO> CompleteList(int odNo);

}
