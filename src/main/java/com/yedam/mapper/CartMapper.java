package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.CartListVO;

public interface CartMapper {
	public List<CartListVO> selectCartList(String userId);
	public int deleteList(String userId);
	public int eachDelCart(@Param("userId")String userId, @Param("prdNo")int prdNo);
}
