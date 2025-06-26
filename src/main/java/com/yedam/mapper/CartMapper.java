package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.CartListVO;

public interface CartMapper {
	public List<CartListVO> selectCartList(String userId);
	public int deleteList(String userId);
}
