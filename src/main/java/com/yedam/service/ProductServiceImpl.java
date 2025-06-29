package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.ProductMapper;
import com.yedam.vo.ProductVO;
import com.yedam.vo.StockVO;

public class ProductServiceImpl implements ProductService {

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
	
	//상품 전체
	@Override
	public List<ProductVO> productList() {
		return mapper.selectList();
	}
	
	//상품목록 페이징
	@Override
	public List<ProductVO> productListPaging(int page) {
		
		return mapper.selectListPaging(page);
	}

	// 카테고리
	@Override
	public List<ProductVO> productListCategory(int page, String prdSort) {
		
		return mapper.selectCategory(page, prdSort);
	}
	// 카테고리 수량체크
	@Override
	public List<ProductVO> productCount() {
		
		return mapper.selectCount();
	}
	// 옵션별 목록 
	@Override
	public List<ProductVO> productOption(SearchDTO search) {
		
		return mapper.selectOption(search);
	}

	@Override
	public List<ProductVO> productSearch(String keyword ,int page) {
		
		return mapper.selectSearch(keyword, page);
	}

	@Override
	public int productPage() {
		
		return mapper.selectCountPage();
	}

	@Override
	public boolean addProduct(ProductVO product) {
		int r = mapper.insertProduct(product);
		
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		
		return false;
	}

	@Override
	public boolean firstStock(int prdStock) {
		int r = mapper.firstStock(prdStock);
		
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		
		return false;
	}

	@Override
	public List<ProductVO> stockList() {
		return mapper.stockList();
	}

	@Override
	public boolean insertStock(StockVO stock) {
		int r = mapper.insertStock(stock);
		
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		
		return false;
	}

	// 상품 검색 목록 페이징
	@Override
	public int productSearchPage(String keyword) {
		
		return mapper.selectCountSearch(keyword);
	}



}
