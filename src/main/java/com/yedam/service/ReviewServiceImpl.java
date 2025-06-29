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
	@Override
	public boolean addReview(ReviewVO review) {
		int r = mapper.insertReview(review);
		if(r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}
}
