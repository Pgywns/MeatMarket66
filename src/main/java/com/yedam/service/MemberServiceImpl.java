package com.yedam.service;

import java.util.List;

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

	@Override
	public MemberVO login(String id, String pw) {
		return mapper.selectMemberForLogin(id, pw);
	}

	@Override
	public boolean userCheck(String id) {
		return mapper.selectMember(id) == null;
	}

	@Override
	public String findId(String name, String phone) {
		return mapper.selectId(name, phone);
	}

	@Override
	public String findPassword(String id, String name, String phone) {
		return mapper.selectPassword(id, name, phone);
	}

	@Override
	public MemberVO userSelect(String id) {
		return mapper.userSelect(id);
	}

	@Override
	public boolean updateUser(MemberVO member) {
		int r = mapper.updateUser(member);
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}
}
