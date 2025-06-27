package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.OrderMapper;
import com.yedam.vo.AddressVO;
import com.yedam.vo.OrderVO;

public class OrderServiceImpl implements OrderService {
	SqlSession sqlSession = DataSource.getInstance().openSession();
	OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
	@Override
	public List<AddressVO> findAddress(String userId) {
		return mapper.selectFirstAddress(userId);
	}
	@Override
	public boolean submitOrderForm(OrderVO form) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
