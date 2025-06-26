package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.common.SearchDTO;
import com.yedam.vo.ProductVO;

public interface ProductMapper {
	// 상품 전체
	public List<ProductVO> selectList();

	// 페이징
	public List<ProductVO> selectListPaging(@Param("page") int page);
	public List<ProductVO> selectListWithPaging(SearchDTO search);

	// 사이드 카테고리
	public List<ProductVO> selectCategory(String prdSort);

	// 사이드 카테고리 수량
	public List<ProductVO> selectCount();

	// 옵션별 리스트 출력
	public List<ProductVO> selectOption(SearchDTO search);
	
}
