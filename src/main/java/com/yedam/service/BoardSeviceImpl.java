package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;
import com.yedam.vo.ReviewVO;

public class BoardSeviceImpl implements BoardSevice{
	SqlSession sqlSession = DataSource.getInstance().openSession();
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	@Override
	public List<BoardVO> boardList() {
		// TODO Auto-generated method stub
		return mapper.selectList();
	}
	@Override
	public List<BoardVO> clickboardList(String boardCategory) {
		// TODO Auto-generated method stub
		return mapper.clickList(boardCategory);
	}
	@Override
	public boolean insertBoard(String userId, String boardTitle, String boardContent,String boardCategory) {
		int r = mapper.addBoard(userId,boardTitle,boardContent,boardCategory);
		if(r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public int BoardToTalCount(String id) {
		return mapper.BoardToTalCount(id);
	}
	
	@Override
	public List<BoardVO> selectBoards(String id) {
		return mapper.selectBoards(id);
	}
	@Override
	public List<BoardVO> selectMyBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.selectBoardToUserId(board);
	}
}
