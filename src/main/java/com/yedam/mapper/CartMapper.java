package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.CartListVO;
import com.yedam.vo.CartVO;

public interface CartMapper {
	public List<CartListVO> selectCartList(String userId);
	public int deleteList(String userId);
	public int eachDelCart(@Param("userId")String userId, @Param("prdNo")int prdNo);
	public int updateCartQty(@Param("userId")String userId, @Param("prdNo")int prdNo, @Param("cartQty")int cartQty);
	
	//장바구니 클릭시 
	public int insertCart(CartVO cart);
}
