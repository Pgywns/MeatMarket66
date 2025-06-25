<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-fluid py-5 mb-5 hero-header">
	<div class="board-container">
		<nav>
			<h2>고객 센터</h2>
			<!-- click이벤트 발생 -->
			<ul class="nav justify-content-center">
				<li><div class="faq-tab__text"
						style="margin: 12px 0px 0px 0px; font-size: 25px">상품관련</div></li>
				<li><div class="faq-tab__text"
						style="margin: 12px 25px 0px 25px; font-size: 25px">주문/결제</div></li>
				<li><div class="faq-tab__text"
						style="margin: 12px 25px 0px 25px; font-size: 25px">배송</div></li>
				<li><div class="faq-tab__text"
						style="margin: 12px 25px 0px 25px; font-size: 25px">변경 / 취소
						/반품</div></li>
				<li><div class="faq-tab__text"
						style="margin: 12px 25px 0px 25px; font-size: 25px">회원정보</div></li>
				<li><div class="faq-tab__text"
						style="margin: 12px 25px 0px 25px; font-size: 25px">내 문의</div></li>
			</ul>
		</nav>
	</div>
	<div class="container">
		<div class="accordion w-50 " id="accordionExample"></div>
		<!-- forEach반복부분 -->
		<!-- 부트스트랩 아코디언  -->
	</div>
</div>
<script type="text/javascript" src="./js/board/board.js"></script>