package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardMapper {
	//고객센터글목록 
	public List<BoardVO> selectList();
	public List<BoardVO> clickList(String boardCategory);
	
	//1:1문의 글 추가
	public int addBoard(String userId);
	
	// 내문의 카운트
	public int BoardToTalCount(String id);
	// 내문의 전체조회
	public List<BoardVO> selectBoards(String id);
}
