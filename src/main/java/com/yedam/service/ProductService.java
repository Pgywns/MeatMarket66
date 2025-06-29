package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.ProductVO;
import com.yedam.vo.StockVO;

public interface ProductService {
	// 상품전체
	List<ProductVO> productList();

	// 상품전체 페이징
	List<ProductVO> productListPaging(int page);

	// 카테고리
	List<ProductVO> productListCategory(int page, String prdSort);

	// 카테고리별 수량
	List<ProductVO> productCount();

	// 옵션별 리스트 with Paging
	List<ProductVO> productOption(SearchDTO search);
	
	// 검색 기능
	List<ProductVO> productSearch(String keyword, int page);
	
	// 검색 페이지네이션
	int productSearchPage(String keyword);
	//페이지네이션..
	int productPage();
	
	// 상품 추가
	boolean addProduct(ProductVO product);
	
	// 재고 최초 추가
	boolean firstStock(int prdStock);
	
	// 재고를 포함한 상품조회
	List<ProductVO> stockList();
	
	// 입출고
	boolean insertStock(StockVO stock);
	
	//상품코드 재고조회
	int checkStockByPrdNO(int prdNo);

}
