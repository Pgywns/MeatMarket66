package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReviewVO;

public interface ReviewService {
	public List<ReviewVO> rvwList(int prdNo);
	
	//리뷰 건수 카운트
	public int totalReview(String id);
	// 로그인한 아이디로 리뷰 조회
	public List<ReviewVO> selectReviewToUserId(String id);
}
