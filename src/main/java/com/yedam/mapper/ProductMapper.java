package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ProductVO;

public interface ProductMapper {
	// 상품 전체
	public List<ProductVO> selectList();
}
