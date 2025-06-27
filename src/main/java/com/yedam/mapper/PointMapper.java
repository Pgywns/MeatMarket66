package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.PointVO;

public interface PointMapper {
	// 포인트 카운트
	public int selectTotalPoint(String id);
	
	//포인트 조회
	public List<PointVO> selectPoint(String id);
}
