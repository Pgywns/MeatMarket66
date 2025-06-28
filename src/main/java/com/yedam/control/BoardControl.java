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

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		
		String auth = null;
		HttpSession session = req.getSession();
		if (session.getAttribute("auth") != null) {
			auth = (String) session.getAttribute("auth");			
		}
		
		if (auth == null || auth.equals("user")) {
			req.getRequestDispatcher("board/board.tiles").forward(req, resp);
		} else if (auth != null || auth.equals("admin")) {
			req.getRequestDispatcher("admin/board/board.tiles").forward(req, resp);
		}
	}

}
