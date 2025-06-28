package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.CompleteMapper;
import com.yedam.vo.CompleteListVO;
import com.yedam.vo.OrderVO;

public class CompleteServiceImpl implements CompleteService {

	SqlSession sqlSession = DataSource.getInstance().openSession();
	CompleteMapper mapper = sqlSession.getMapper(CompleteMapper.class);
	
	@Override
	public OrderVO orderInfo(String userId) {
		return mapper.selectOrderInfo(userId);
	}

	@Override
	public List<CompleteListVO> CompleteList(int odNo) {
		return mapper.selectCompleteList(odNo);
	}

	
}
