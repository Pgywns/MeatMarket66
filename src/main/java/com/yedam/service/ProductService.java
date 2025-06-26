package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.ProductVO;

public interface ProductService {
	// 상품전체
	List<ProductVO> productList();
	
	//페이징
	List<ProductVO> productListPaging(int page);
	
	//카테고리
	List<ProductVO> productListCategory(String prdSort);
	
	//카테고리별 수량
	List<ProductVO> productCount();
}
