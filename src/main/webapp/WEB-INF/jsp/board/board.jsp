<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-fluid py-5 mb-5 hero-header">
<div class="board-container">
	<nav>
		<h2>고객 센터</h2>
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
<!-- 부트스트랩 아코디언  -->
<div class="accordion w-50 " id="accordionExample">
	<div class="accordion-item">
		<!-- 아코디언 초기상태ㅣ접힘 -->
		<button class="accordion-button collapsed" type="button"
			data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
			aria-expanded="false" aria-controls="flush-collapseOne"
			style="height: 55px">
			<h5 class="accordion-header">상품관련</h5>
			<p style="">[공통]이력번호는 어떻게 확인하나요?</p>
		</button>
	</div>
</div>
<div>
	<div id="flush-collapseOne" class="accordion-collapse collapse"
		data-bs-parent="#accordionFlushExample ">
		<div class="accordion-body w-50">
			<p>각 상품의 이력번호는 개별 상품 라벨에 표시되어 있으며 축산물이력제 페이지에 (http://aunit.mtrace.go.kr/) 이력번호를 입력하시면 해당 상품의 이력을 쉽게 조회하실 수 있습니다.</p>
		</div>
	</div>
</div>
</div>
