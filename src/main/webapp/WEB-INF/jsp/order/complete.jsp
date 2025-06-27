<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" href="./css/order/modalstyles.css" />

<!-- 헤더 -->
<div class="container-fluid page-header py-5">
	<h1 class="text-center text-white display-6">Order Complete</h1>
</div>

<!-- 본문 -->
<div class="container-fluid py-5">
	<div class="container py-5">

		<!-- ✅ 주문 완료 메시지 -->
		<div class="text-center mb-5">
			<h2 class="fw-bold">주문이 완료되었습니다.</h2>
			<p class="text-muted mt-3">고객님의 소중한 주문 감사합니다.</p>
		</div>

		<!-- ✅ 주문 정보 -->
		<div class="row justify-content-center mb-5">
			<div class="col-md-8 col-lg-7">
				<div class="border rounded-3 p-4 bg-light">
					<h5 class="fw-bold mb-3">주문 정보</h5>
					<p><strong>주문일자:</strong> <span class="text-secondary">2025-06-27</span></p>
					<p><strong>받는 분:</strong> <span class="text-secondary">홍길동</span></p>
					<p><strong>배송지:</strong> <span class="text-secondary">서울특별시 중구 세종대로 110</span></p>
					<p><strong>연락처:</strong> <span class="text-secondary">010-1234-5678</span></p>
				</div>
			</div>
		</div>

		<!-- ✅ 주문 상품 리스트 -->
		<div class="row justify-content-center">
			<div class="col-md-10">
				<div class="table-responsive border rounded-3">
					<table class="table mb-0">
						<thead style="background-color: #e6f4e6;"> <!-- 연두색 계열 -->
							<tr>
								<th scope="col">상품</th>
								<th scope="col">상품명</th>
								<th scope="col">가격</th>
								<th scope="col">수량</th>
								<th scope="col">금액</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><img src="./img/찌개용.png" alt="상품이미지" style="width: 50px;"></td>
								<td>초신선 돼지 찌개용</td>
								<td>7,500</td>
								<td>2</td>
								<td>15,000</td>
							</tr>
							<tr>
								<th scope="row" colspan="4" class="text-end">Subtotal</th>
								<td>15,000</td>
							</tr>
							<tr>
								<th scope="row" colspan="4" class="text-end">사용적립금</th>
								<td>0 P</td>
							</tr>
							<tr>
								<th scope="row" colspan="4" class="text-end text-uppercase">Total</th>
								<td><strong>15,000원</strong></td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="text-end mt-4">
					<p class="text-muted">※ 주문 상세 내용은 마이페이지 > 주문내역에서 확인하실 수 있습니다.</p>
				</div>
			</div>
		</div>
	</div>
</div>