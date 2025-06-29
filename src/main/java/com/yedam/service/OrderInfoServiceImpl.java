package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.OrderInfoMapper;
import com.yedam.vo.OrderInfoVO;

public class OrderInfoServiceImpl implements OrderInfoService {
	
	SqlSession sqlSession = DataSource.getInstance().openSession();
	OrderInfoMapper mapper = sqlSession.getMapper(OrderInfoMapper.class);
	
	@Override
	public List<OrderInfoVO> orderInfoList(int odNo) {
		return mapper.selectOrderInfo(odNo);
	}

}
