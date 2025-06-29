package com.yedam.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.BoardVO;
import com.yedam.vo.ReviewVO;

public interface BoardSevice {
	public List<BoardVO> boardList();
	public List<BoardVO> clickboardList(String boardCategory);
	// 글 추가
	public boolean insertBoard(String userId, String boardTitle, String boardContent,String boardCategory);
	//로그인아이디로 게시글 조회
	public List<ReviewVO> selectBoardToUserId(String userId);
}
