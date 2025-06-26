package com.yedam.service;

import com.yedam.vo.MemberVO;

public interface MemberService {
	// 회원가입
	public boolean insertMember(MemberVO member);
	
	//로그인
	public MemberVO login(String id, String pw);
	
	// 아이디 체크하기 위한 select
	public boolean userCheck(String id);
	
	// 아이디 찾기
	public String findId(String name, String phone);
	// 비밀번호 찾기
	public String findPassword(String id, String name, String phone);
}
