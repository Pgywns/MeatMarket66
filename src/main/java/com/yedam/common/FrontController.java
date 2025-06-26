package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddProductFormControl;
import com.yedam.control.BoardControl;
import com.yedam.control.CartControl;
import com.yedam.control.CartPageControl;
import com.yedam.control.CompleteOrder;
import com.yedam.control.FindAccountControl;
import com.yedam.control.FindIdControl;
import com.yedam.control.FindPasswordControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MainControl;
import com.yedam.control.MyPageControl;
import com.yedam.control.OrderControl;
import com.yedam.control.ProductCategoryControl;
import com.yedam.control.ProductDetailControl;
import com.yedam.control.ProductListControl;
import com.yedam.control.ProductListControlPaging;
import com.yedam.control.ProductOptionControl;
import com.yedam.control.RegisterControl;
import com.yedam.control.StockListControl;
import com.yedam.control.UserCheckControl;



// 서블릿
public class FrontController extends HttpServlet {
	Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<String, Control>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl());
		//상품
		map.put("/productDetail.do", new ProductDetailControl());
		map.put("/proudctList.do", new ProductListControl());
		map.put("/productListPaging.do",  new ProductListControlPaging());
		map.put("/productCategory.do", new ProductCategoryControl());
		map.put("/productListOption.do", new ProductOptionControl());
		

		
		

		// 로그인
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		map.put("/register.do", new RegisterControl());
		map.put("/userCheck.do", new UserCheckControl());
		
		// 아이디 비밀번호찾기
		map.put("/findAccount.do", new FindAccountControl());
		map.put("/findId.do", new FindIdControl());
		map.put("/findPassword.do", new FindPasswordControl());
		
		// 마이페이지
		map.put("/myPage.do", new MyPageControl());
		
		//장바구니
		map.put("/cartPage.do", new CartPageControl());
		map.put("/cart.do", new CartControl());
		
		//주문페이지
		map.put("/order.do", new OrderControl());
		map.put("/complete.do", new CompleteOrder());
		
		// 관리자
		map.put("/addProductForm.do", new AddProductFormControl());
		map.put("/stockList.do", new StockListControl());
		
		//고객센터
		map.put("/board.do", new BoardControl());


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
