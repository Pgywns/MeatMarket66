package com.yedam.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.BoardVO;

public interface BoardSevice {
	public List<BoardVO> boardList();
	public List<BoardVO> clickboardList(String boardCategory);
	// 글 추가
	public boolean insertBoard(@Param("userId")String userId);
	
	// 내 문의 카운트
	public int BoardToTalCount(String id);
	// 내 문의 전체조회
	public List<BoardVO> selectBoards(String id);
}
