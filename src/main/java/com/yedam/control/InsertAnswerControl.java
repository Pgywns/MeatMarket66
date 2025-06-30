package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardSevice;
import com.yedam.service.BoardSeviceImpl;
import com.yedam.vo.BoardVO;

public class InsertAnswerControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String boardNo = req.getParameter("boardNo");
		String answer = req.getParameter("answer");
		
		BoardSevice svc = new BoardSeviceImpl();
		
		BoardVO board = new BoardVO();
		board.setBoardNo(Integer.parseInt(boardNo));
		board.setAnswer(answer);
		
		if (svc.insertAnswer(board)) {
			resp.getWriter().print("{\"retCode\":\"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}
	}

}
