package com.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.AddressService;
import com.yedam.service.AddressServiceImpl;
import com.yedam.vo.AddressVO;

public class SelectAddressControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		
		AddressService svc = new AddressServiceImpl();
		List<AddressVO> list = svc.selectAddress(userId);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);
		System.out.println(json);
		
		PrintWriter out = resp.getWriter();
		out.print(json);
	}

}
