package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.BoardSevice;
import com.yedam.service.BoardSeviceImpl;
import com.yedam.service.ReviewService;
import com.yedam.service.ReviewServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardinsertControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 //현재 로그인한 사용자 아이디 세션 가져온다
		HttpSession session = req.getSession();
		String userId= (String)session.getAttribute("userId");
		//로그인이 아닐때
		if(userId == null) {
			req.getRequestDispatcher("member/member.tiles").forward(req, resp);
			return;
		}
		//한글처리
		req.setCharacterEncoding("UTF-8");//클라이언트->서버
		resp.setCharacterEncoding("utf-8");//서버->클라이언트
		resp.setContentType("text/json;charset=utf-8");
		
	    // GET 요청이면 작성 폼 보여주기
		String method = req.getMethod();
		method = method.toUpperCase();
		
	    if (method.equals("GET")) {
	        req.getRequestDispatcher("board/boardinsert.tiles").forward(req, resp);
	        return;
	    }
	    
	    String boardTitle = req.getParameter("boardTitle");
		String boardContent = req.getParameter("boardContent");
		String boardCategory = req.getParameter("boardCategory");
		BoardVO board = new BoardVO();
		board.setUserId(userId);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setBoardCategory(boardCategory);
		BoardSevice svc = new BoardSeviceImpl();
		boolean result = svc.insertBoard(userId, boardTitle,boardContent,boardCategory);
		
		if(result) {
			resp.sendRedirect("board.do");
		}
		else {
            req.setAttribute("message", "글 등록에 실패했습니다. 다시 시도해주세요.");
            req.getRequestDispatcher("board/boardinsert.tiles").forward(req, resp);
		}
		System.out.println(result);
		
	}

}
