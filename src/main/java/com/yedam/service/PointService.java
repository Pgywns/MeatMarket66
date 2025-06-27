package com.yedam.service;

public interface PointService {
	// 카운트
	public int totalPoint(String id);
	public boolean usingPoint(String userId, int usingPoint);
}
