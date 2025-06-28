package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.OrderMapper;
import com.yedam.vo.AddressVO;
import com.yedam.vo.CartVO;
import com.yedam.vo.OrderVO;

public class OrderServiceImpl implements OrderService {
	SqlSession sqlSession = DataSource.getInstance().openSession();
	OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
	@Override
	public List<AddressVO> findAddress(String userId) { //기본주소
		return mapper.selectFirstAddress(userId);
	}
	@Override
	public boolean submitOrderForm(OrderVO form) { //주문T등록
		int r= mapper.insesrtOrderForm(form);
		if(r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}
	@Override
	public int returnOrderNo(String userId) { //주문번호
		return mapper.selectOrderNo(userId);
	}
	@Override
	public List<CartVO> OrderList(String userId) { //장바구니 목록
		return mapper.selectOrderList(userId);
	}
	@Override
	public boolean sumitOrderInfo(int odNo, int prdNo, int orderQty) {//주문T상세등록
		int r = mapper.insertOrderInfo(odNo, prdNo, orderQty);
		if(r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}
	@Override
	public boolean outStock(int prdNo, int orderQty) {//재고반영
		int r = mapper.insertOutStock(prdNo, orderQty);
		if(r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}
	@Override
	public boolean addPoint(String userId, int addPoint) { //포인트적립
		int r = mapper.insertAddPoint(userId, addPoint);
		if(r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}
	
}
