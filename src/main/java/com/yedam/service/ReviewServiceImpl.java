package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReviewMapper;
import com.yedam.vo.ReviewVO;

public class ReviewServiceImpl implements ReviewService{
	SqlSession sqlSession = DataSource.getInstance().openSession();
	ReviewMapper mapper = sqlSession.getMapper(ReviewMapper.class);  
	@Override
	public List<ReviewVO> rvwList(int prdNo) {
		// TODO Auto-generated method stub
		return mapper.selectReviewList(prdNo);
	}
	@Override
	public int totalReview(String id) {
		return mapper.totalReivew(id);
	}

	@Override
	public List<ReviewVO> selectReviewToUserId(String id) {
		return mapper.selectReviewToUserId(id);
	}
}
