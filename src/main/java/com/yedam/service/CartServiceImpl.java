package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.CartMapper;
import com.yedam.vo.CartListVO;
import com.yedam.vo.CartVO;

public class CartServiceImpl implements CartService{

	SqlSession sqlSession = DataSource.getInstance().openSession();
	CartMapper mapper = sqlSession.getMapper(CartMapper.class);
	
	@Override //userId기준 장바구니 목록출력
	public List<CartListVO> cartList(String userId) {
		return mapper.selectCartList(userId);
	}

	@Override //장바구니 비우기
	public boolean emptyAll(String userId) {
		int r = mapper.deleteList(userId);
		if (r > 1) {  //1건이상 삭제되면 성공! 
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override //장바구니 단건삭제
	public boolean eachDel(String userId, int prdNo) {
		int r = mapper.eachDelCart(userId, prdNo);
		if(r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override //장바구니 수량변경
	public boolean updateQty(String userId, int prdNo, int cartQty) {
		int r = mapper.updateCartQty(userId, prdNo, cartQty);
		if(r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override // 장바구니아이콘 클릭시 추가
	public boolean addCart(CartVO cart) {
		
		int r = mapper.insertCart(cart);
		if( r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}
	

	@Override
	public int CountCartList(String userId) {
		return mapper.selectCountCart(userId);

	}

}
