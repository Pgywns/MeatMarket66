package com.yedam.service;

import java.util.List;

import com.yedam.vo.ProductVO;

public interface ProductService {
	// 상품전체
	List<ProductVO> productList();
	//페이징
	List<ProductVO> productListPaging(int page);
	
}
