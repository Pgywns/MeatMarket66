package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.CartMapper;
import com.yedam.vo.CartListVO;

public class CartServiceImpl implements CartService{

	SqlSession sqlSession = DataSource.getInstance().openSession();
	CartMapper mapper = sqlSession.getMapper(CartMapper.class);
	
	@Override
	public List<CartListVO> cartList(String userId) {
		return mapper.selectCartList(userId);
	}

	@Override
	public boolean emptyAll(String userId) {
		int r = mapper.deleteList(userId);
		if (r > 1) {  //1건이상 삭제되면 성공! 
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean eachDel(String userId, int prdNo) {
		int r = mapper.eachDelCart(userId, prdNo);
		if(r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

}
