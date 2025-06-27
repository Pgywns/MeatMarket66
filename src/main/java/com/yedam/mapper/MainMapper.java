package com.yedam.mapper;


import java.util.List;

import com.yedam.vo.ProductVO;
import com.yedam.vo.ReviewVO;

public interface MainMapper {
	
	public List<ProductVO> selectMil();
	
	public List<ProductVO> selectHot();
	
	public List<ReviewVO> selectReview();
}
