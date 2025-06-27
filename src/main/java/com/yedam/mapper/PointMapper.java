package com.yedam.mapper;

import org.apache.ibatis.annotations.Param;

public interface PointMapper {
	// 포인트 카운트
	public int selectTotalPoint(String id);
	//포인트사용
	public int usingPoint(@Param("userId")String userId, @Param("usingPoint")int usingPoint);
}
