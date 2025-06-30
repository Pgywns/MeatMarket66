package com.yedam.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.BoardVO;
import com.yedam.vo.ReviewVO;

public interface BoardSevice {
	public List<BoardVO> boardList();
	public List<BoardVO> clickboardList(String boardCategory);
	//내문의
	public List<BoardVO> selectMyBoard(BoardVO board);
	// 글 추가
	public boolean insertBoard(String userId, String boardTitle, String boardContent,String boardCategory);
	
	// 내 문의 카운트
	public int BoardToTalCount(String id);
	// 내 문의 전체조회
	public List<BoardVO> selectBoards(String id);
}
