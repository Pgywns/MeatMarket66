package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	SqlSession sqlSession = DataSource.getInstance().openSession();
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	// 회원가입
	@Override
	public boolean insertMember(MemberVO member) {
		int r = mapper.insertMember(member);
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

}
