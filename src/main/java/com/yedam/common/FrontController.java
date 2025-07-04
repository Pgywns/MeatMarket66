package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddProductControl;
import com.yedam.control.AddProductFormControl;
import com.yedam.control.AddReviewControl;
import com.yedam.control.AddressPop;
import com.yedam.control.AdminBoardListControl;
import com.yedam.control.AdminProductListControl;
import com.yedam.control.BoardAnswerControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardFormControl;
import com.yedam.control.BoardListControl;

import com.yedam.control.BoardinsertControl;
import com.yedam.control.CartAddControl;

import com.yedam.control.CartControl;
import com.yedam.control.CartEmpty;
import com.yedam.control.CartPageControl;
import com.yedam.control.CartPrdDel;
import com.yedam.control.CartUpdateQty;
import com.yedam.control.ChangeFalseControl;
import com.yedam.control.ChangeFirstAddrControl;
import com.yedam.control.CheckStock;
import com.yedam.control.CompleteInfo;
import com.yedam.control.CompleteList;
import com.yedam.control.CompleteOrder;
import com.yedam.control.CountCart;
import com.yedam.control.DeleteAddressControl;
import com.yedam.control.DetailReviewControl;
import com.yedam.control.DispayAddressControl;
import com.yedam.control.FindAccountControl;
import com.yedam.control.FindIdControl;
import com.yedam.control.FindPasswordControl;
import com.yedam.control.InsertAddressControl;
import com.yedam.control.InsertAnswerControl;
import com.yedam.control.InsertStockControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MainControl;
import com.yedam.control.MainMilControl;
import com.yedam.control.MyBoardListControl;
import com.yedam.control.MyPageControl;
import com.yedam.control.OrderMyPoint;
import com.yedam.control.SubmitOrderForm;
import com.yedam.control.OrderControl;
import com.yedam.control.ProductCategoryControl;
import com.yedam.control.ProductDetailControl;
import com.yedam.control.ProductListControl;
import com.yedam.control.ProductListControlPaging;
import com.yedam.control.ProductOptionControl;
import com.yedam.control.ProductPageControl;
import com.yedam.control.ProductSearchControl;
import com.yedam.control.ProductSearchPageControl;
import com.yedam.control.RegisterControl;
import com.yedam.control.ReviewFormControl;

import com.yedam.control.SelectAddressControl;
import com.yedam.control.SelectBoardControl;
import com.yedam.control.SelectOrderControl;
import com.yedam.control.SelectOrderInfoControl;
import com.yedam.control.SelectPointControl;

import com.yedam.control.SelectReviewControl;
import com.yedam.control.SelectUserControl;
import com.yedam.control.StockListControl;
import com.yedam.control.UpdateUserControl;
import com.yedam.control.UserCheckControl;
import com.yedam.control.UsingPoint;

// 서블릿
public class FrontController extends HttpServlet {
	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<String, Control>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 메인화면
		map.put("/main.do", new MainControl());
		map.put("/mainMil.do", new MainMilControl());
		
		// 상품
		map.put("/productDetail.do", new ProductDetailControl());
		map.put("/proudctList.do", new ProductListControl());
		map.put("/productListPaging.do", new ProductListControlPaging());
		map.put("/productCategory.do", new ProductCategoryControl());
		map.put("/productListOption.do", new ProductOptionControl());
		map.put("/productSearch.do", new ProductSearchControl());
		map.put("/detailReview.do", new DetailReviewControl());
		map.put("/productPage.do", new ProductPageControl());
		map.put("/productSearchPage.do",new ProductSearchPageControl());
		
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
		map.put("/selectOrder.do", new SelectOrderControl());
		map.put("/selectOrderInfo.do", new SelectOrderInfoControl());
		map.put("/selectReveiw.do", new SelectReviewControl());
		map.put("/selectPoint.do", new SelectPointControl());
		map.put("/selectBoard.do", new SelectBoardControl());
		map.put("/selectUser.do", new SelectUserControl());
		map.put("/selectAddress.do", new SelectAddressControl());
		map.put("/updateUser.do", new UpdateUserControl());
		map.put("/insertAddress.do", new InsertAddressControl());
		map.put("/deleteAddress.do", new DeleteAddressControl());
		map.put("/changeFirstAddr.do", new ChangeFirstAddrControl());
		map.put("/changeFalse.do", new ChangeFalseControl());
		
		//장바구니
		map.put("/cartPage.do", new CartPageControl());
		map.put("/cart.do", new CartControl());
		map.put("/cartEmpty.do", new CartEmpty());
		map.put("/cartPrdDel.do", new CartPrdDel());
		map.put("/cartUpdateQty.do", new CartUpdateQty());
		map.put("/cartIcon.do", new CountCart());
		map.put("/cartAdd.do", new CartAddControl());
		map.put("/checkStock.do", new CheckStock());

		//주문페이지
		map.put("/order.do", new OrderControl());
		map.put("/myPoint.do", new OrderMyPoint());
		map.put("/usingPoint.do", new UsingPoint());
		map.put("/displayAddress.do", new DispayAddressControl());
		map.put("/SubmitOrderForm.do", new SubmitOrderForm());
		map.put("/addressPop.do", new AddressPop());
		
		// 주문완료
		map.put("/complete.do", new CompleteOrder());
		map.put("/completeInfo.do", new CompleteInfo());
		map.put("/completeList.do", new CompleteList());

		// 관리자
		map.put("/addProductForm.do", new AddProductFormControl());
		map.put("/addProduct.do", new AddProductControl());
		map.put("/stockList.do", new StockListControl());
		map.put("/adminProductList.do", new AdminProductListControl());
		map.put("/insertStock.do", new InsertStockControl());
		map.put("/boardAnswer.do", new BoardAnswerControl());
		map.put("/adminBoardList.do", new AdminBoardListControl());
		map.put("/insertAnswer.do", new InsertAnswerControl());
		
		// 고객센터
		map.put("/board.do", new BoardControl());
		map.put("/boardList.do", new BoardListControl());
		map.put("/boardinsert.do", new BoardinsertControl());
		map.put("/myBoardList.do", new MyBoardListControl());
		map.put("/boardForm.do", new BoardFormControl());
		
		//리뷰
		map.put("/reviewForm.do", new ReviewFormControl());
		map.put("/addReview.do", new AddReviewControl());
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
