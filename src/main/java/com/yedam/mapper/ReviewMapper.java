package com.yedam.mapper;
 
import java.util.List;

import com.yedam.vo.ReviewVO;

public interface ReviewMapper {
	//리뷰전체
	public List<ReviewVO> selectReviewList(int prdNo); 
	
	// 리뷰 건수 카운트
	public int totalReivew(String id);
	// 로그인한 아이디로 리뷰 조회
	public List<ReviewVO> selectReviewToUserId(String id);
}
