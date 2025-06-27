package com.yedam.service;

import java.util.List;

import com.yedam.vo.PointVO;

public interface PointService {
	// 카운트
	public int totalPoint(String id);
	
	// 조회
	public List<PointVO> selectPoint(String id);

	public boolean usingPoint(String userId, int usingPoint);

}
