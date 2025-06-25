package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.common.SearchDTO;
import com.yedam.vo.ProductVO;

public interface ProductMapper {
	// 상품 전체
	public List<ProductVO> selectList();
	//페이징
	public List<ProductVO> selectListPaging(@Param("page") int page);
	public List<ProductVO> selectListWithPaging(SearchDTO search);
	//사이드 카테고리
	public List<ProductVO> selectCategory(@Param("pSort") String pSort);
	//사이드 카테고리 수량
	public List<ProductVO> selectCount();
	
}
