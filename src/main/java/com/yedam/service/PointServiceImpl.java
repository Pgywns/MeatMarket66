package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.PointMapper;
import com.yedam.vo.PointVO;

public class PointServiceImpl implements PointService {

	SqlSession sqlSession = DataSource.getInstance().openSession();
	PointMapper mapper = sqlSession.getMapper(PointMapper.class);

	@Override
	public int totalPoint(String id) {
		return mapper.selectTotalPoint(id);
	}

	@Override
	public List<PointVO> selectPoint(String id) {
		return mapper.selectPoint(id);
	}
}
