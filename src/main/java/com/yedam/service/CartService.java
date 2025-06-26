package com.yedam.service;

import java.util.List;

import com.yedam.vo.CartListVO;

public interface CartService {
	public List<CartListVO> cartList(String userId);
	public boolean emptyAll(String userId);
}
