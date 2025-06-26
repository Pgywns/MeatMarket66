package com.yedam.service;

import java.util.List;

import com.yedam.vo.MemberVO;

public interface MemberService {
	// 회원가입
	public boolean insertMember(MemberVO member);
	
	//로그인
	public MemberVO login(String id, String pw);
	
	// 아이디 체크하기 위한 select
	public boolean userCheck(String id);
}
