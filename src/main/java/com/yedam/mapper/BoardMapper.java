package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardMapper {
	//고객센터글 전체보여주기
	public List<BoardVO> boardList();
	
	//1:1문의 글 추가
	public int insertcsBord();
	
}
