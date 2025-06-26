package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardSevice {
	public List<BoardVO> boardList();
	public List<BoardVO> clickboardList(String boardCategory);
}
