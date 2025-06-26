package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.CartVO;

public interface CartMapper {
	public List<CartVO> selectCartList(String userId);
}
