package com.yedam.service;

import java.util.List;

import com.yedam.vo.CartVO;

public interface CartService {
	public List<CartVO> cartList(String userId);
}
