<!-- cart.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- Single Page Header start -->
<div class="container-fluid page-header py-5">
	<h1 class="text-center text-white display-6">장바구니</h1>

</div>
<!-- Single Page Header End -->
<!-- Cart Page Start -->
<div class="container-fluid py-5">
	<div class="container py-5">
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">상품</th>
						<th scope="col">상품명</th>
						<th scope="col">가격</th>
						<th scope="col">수량</th>
						<th scope="col">총 액</th>
						<th scope="col">삭제</th>
					</tr>
				</thead>
				<tbody id="basketBody"></tbody>
			</table>
		</div>
		<div class="row g-4 justify-content-end pb-3">
			<div class="col-8">
				<button
					class="btn border-secondary rounded-pill px-3 py-2 text-primary"
					type="button" onclick="javascript:checkedDel()">선택삭제</button>
				<button
					class="btn border-secondary rounded-pill px-3 py-2 text-primary"
					type="button" onclick="javascript:delitem()">전체삭제</button>
			</div>
			<div class="col-sm-8 col-md-7 col-lg-6 col-xl-4">
				<button
					class="btn border-secondary rounded-pill px-3 py-2 text-primary"
					type="button" onclick="location.href='proudctList.do'">쇼핑계속하기</button>
			</div>
		</div>
		<div class="row g-4 justify-content-end">
			<div class="col-8"></div>
			<div class="col-sm-8 col-md-7 col-lg-6 col-xl-4">
				<div class="bg-light rounded">
					<div class="p-4 border-bottom">
						<h1 class="display-6 mb-4">
							장바구니 <span class="fw-normal"></span>
						</h1>
						<div class="d-flex justify-content-between mb-4">
							<h5 class="mb-0 me-4">결제금액:</h5>
							<p class="mb-0 totalEl"></p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-8"></div>
			<div class="col-sm-8 col-md-7 col-lg-6 col-xl-4">
				<input type="checkbox" class="form-check-input bg-primary border-0"
					id="orderCheck" name="orderCheck" /> <label for="orderCheck">주문 상품목록을 확인해주세요.</label>
				<br>
				<button
					class="btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase mb-4 ms-4"
					type="button" onclick="javascript:isCartEmptyCheck()">주문계속진행</button>
			</div>
		</div>
	</div>
</div>

<!-- Cart Page End -->
<script>
  const CONTEXT_PATH = "${pageContext.request.contextPath}";
</script>

<script type="text/javascript" src="./js/cart/cart.js"></script>