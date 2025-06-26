package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

public interface MemberMapper {
	// 회원가입
	public int insertMember(MemberVO member);
	
	//로그인
	public MemberVO selectMemberForLogin(@Param("userId") String id, @Param("userPw") String pw); 
	
	// 아이디 체크하기 위한 select
	public MemberVO selectMember(String id);
}
