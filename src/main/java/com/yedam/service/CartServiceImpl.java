package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.CartMapper;
import com.yedam.vo.CartVO;

public class CartServiceImpl implements CartService{

	SqlSession sqlSession = DataSource.getInstance().openSession();
	CartMapper mapper = sqlSession.getMapper(CartMapper.class);
	
	@Override
	public List<CartVO> cartList(String userId) {
		// TODO Auto-generated method stub
		return mapper.selectCartList(userId);
	}

}
