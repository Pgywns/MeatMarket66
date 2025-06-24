package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.MemberControl;
import com.yedam.control.ProductDetailControl;
import com.yedam.control.ProductListControl;
import com.yedam.control.ProductManagementControl;
import com.yedam.service.MainControl;


// 서블릿
public class FrontController extends HttpServlet {
	Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<String, Control>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/productDetail.do", new ProductDetailControl());
		map.put("/proudctList.do", new ProductListControl());
		
		// 로그인 회원가입
		map.put("/member.do", new MemberControl());
		
		// 관리자
		map.put("/productManagement.do", new ProductManagementControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url이 호출(http://localhots:8080/Project66/main.do) -> 페이지 호출 -> Control
		String uri = req.getRequestURI(); // /Project66/main.do
		String context = req.getContextPath(); // /Project66
		String page = uri.substring(context.length()); // /main.do
		Control sub = map.get(page); // .do 이름이 키 값이기 때문에 밸류인 Control 형태의 변수에 저장
		sub.exec(req, resp); // 각 Control에 있는 exec 메소드 호출
	}
}
