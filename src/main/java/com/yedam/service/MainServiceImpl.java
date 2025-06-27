package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.CartMapper;
import com.yedam.mapper.MainMapper;
import com.yedam.vo.ProductVO;
import com.yedam.vo.ReviewVO;

public class MainServiceImpl implements MainService{

	SqlSession sqlSession = DataSource.getInstance().openSession();
	MainMapper mapper = sqlSession.getMapper(MainMapper.class);
	
	@Override
	public List<ProductVO> newMilList() {
		
		return mapper.selectMil();
	}

	@Override
	public List<ProductVO> hotProductList() {
		
		return mapper.selectHot();
	}

	@Override
	public List<ReviewVO> mainReview() {
		
		return mapper.selectReview();
	}

}
