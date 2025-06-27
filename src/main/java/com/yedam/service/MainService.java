package com.yedam.service;

import java.util.List;

import com.yedam.vo.ProductVO;
import com.yedam.vo.ReviewVO;

public interface MainService {

	// 밀키트 등록일순
	public List<ProductVO> newMilList();

	// 인기 상품
	public List<ProductVO> hotProductList();

	// 리뷰 목록
	public List<ReviewVO> mainReview();
}
