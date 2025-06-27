package com.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

public interface MemberMapper {
	// 회원가입
	public int insertMember(MemberVO member);
	
	//로그인
	public MemberVO selectMemberForLogin(@Param("userId") String id, @Param("userPw") String pw); 
	
	// 아이디 체크하기 위한 select
	public MemberVO selectMember(String id);
	
	//아이디 찾기
	public String selectId(@Param("fidName") String name, @Param("fidPhone") String phone);
	// 비밀번호 찾기
	public String selectPassword(@Param("userId") String id, @Param("userName") String name, @Param("userPhone") String phone);
	
	//회원 한 명 조회
	public MemberVO userSelect(String id);
	
	//정보 수정
	public int updateUser(MemberVO member);
}
