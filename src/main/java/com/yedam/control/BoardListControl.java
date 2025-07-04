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
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
	
		HttpSession session = req.getSession();
		String userId = "admin";
		
		String  boardCategory = req.getParameter("boardCategory");

		BoardVO bvo = new BoardVO();
		bvo.setBoardCategory(boardCategory);
		bvo.setUserId(userId);
		BoardSevice svc = new BoardSeviceImpl();

		List<BoardVO> list = svc.selectMyBoard(bvo);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);
		resp.getWriter().print(json);
		System.out.println(json);
	}
}
