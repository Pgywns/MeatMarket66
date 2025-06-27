package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.PointMapper;

public class PointServiceImpl implements PointService {

	SqlSession sqlSession = DataSource.getInstance().openSession();
	PointMapper mapper = sqlSession.getMapper(PointMapper.class);
	
	@Override
	public int totalPoint(String id) {
		return mapper.selectTotalPoint(id);
	}

}
