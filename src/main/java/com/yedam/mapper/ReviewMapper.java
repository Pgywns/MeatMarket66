package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ReviewVO;

public interface ReviewMapper {
	//리뷰전체
	public List<ReviewVO> selectReviewList(); 
}
