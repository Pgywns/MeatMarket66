package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.BoardVO;
import com.yedam.vo.ReviewVO;

public interface BoardMapper {
	//고객센터글목록 
	public List<BoardVO> selectList();
	public List<BoardVO> clickList(String boardCategory);
	//1:1문의 글 추가
	public int addBoard(@Param("userId")String userId,@Param("boardTitle")String boardTitle,@Param("boardContent")String boardContent,@Param("boardCategory")String boardCategory);
	// 로그인아이디로 게시글 조회
	public List<ReviewVO> selectBoardToUserId(String userId);
}
