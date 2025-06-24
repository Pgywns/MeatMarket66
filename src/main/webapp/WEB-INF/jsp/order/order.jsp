<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- Single Page Header start -->
<div class="container-fluid page-header py-5">
	<h1 class="text-center text-white display-6">Checkout</h1>
</div>
<!-- Single Page Header End -->


<!-- Checkout Page Start -->
<div class="container-fluid py-5">
	<div class="container py-5">
		<h1 class="mb-4">Billing details</h1>
		<form action="#">
			<div class="row g-5">
				<div class="col-md-12 col-lg-6 col-xl-7">
					<div class="form-item">
						<label class="form-label my-3">받으시는 분<sup>*</sup></label> <input
							type="text" class="form-control">
					</div>
					<!-- 주소영역 -->
					<div class="row my-3">
						<div>
							<input type="radio" id="defaultAdd" name="defaultAdd">
							<label for="defaultAdd">기본 배송지</label>
							<input type="radio" id="newtAdd" name="newAdd">
							<label for="newAdd">새로운 배송지 등록</label>
						</div>
						<div class="col-md-12 col-lg-6">
							<div class="form-item w-100">
								<label class="form-label my-3">우편번호<sup>*</sup></label> <input
									type="text" class="form-control">
							</div>
						</div>
						<div class="col-md-12 col-lg-6">
							<div class="form-item w-100">
								<label class="form-label my-3">주소<sup>*</sup></label> <input
									type="text" class="form-control">
							</div>
						</div>
						<div class="form-item">
							<label class="form-label my-3">상세주소<sup>*</sup></label> <input
								type="text" class="form-control"
								placeholder="House Number Street Name">
						</div>
					</div>
					<div class="form-item">
						<label class="form-label my-3">연락처<sup>*</sup></label> <input
							type="tel" class="form-control">
					</div>
				</div>
				<div class="col-md-12 col-lg-6 col-xl-5">
					<div class="table-responsive">
						<table class="table">
							<thead>
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
									<th scope="row">
										<div class="d-flex align-items-center mt-2">
											<img src="img/vegetable-item-2.jpg"
												class="img-fluid rounded-circle"
												style="width: 90px; height: 90px;" alt="">
										</div>
									</th>
									<td class="py-5">Awesome Brocoli</td>
									<td class="py-5">$69.00</td>
									<td class="py-5">2</td>
									<td class="py-5">$138.00</td>
								</tr>
								<tr>
									<th scope="row">
										<div class="d-flex align-items-center mt-2">
											<img src="img/vegetable-item-5.jpg"
												class="img-fluid rounded-circle"
												style="width: 90px; height: 90px;" alt="">
										</div>
									</th>
									<td class="py-5">Potatoes</td>
									<td class="py-5">$69.00</td>
									<td class="py-5">2</td>
									<td class="py-5">$138.00</td>
								</tr>
								<tr>
									<th scope="row">
										<div class="d-flex align-items-center mt-2">
											<img src="img/vegetable-item-3.png"
												class="img-fluid rounded-circle"
												style="width: 90px; height: 90px;" alt="">
										</div>
									</th>
									<td class="py-5">Big Banana</td>
									<td class="py-5">$69.00</td>
									<td class="py-5">2</td>
									<td class="py-5">$138.00</td>
								</tr>
								<tr>
									<th scope="row"></th>
									<td class="py-5"></td>
									<td class="py-5"></td>
									<td class="py-5">
										<p class="mb-0 text-dark py-3">Subtotal</p>
									</td>
									<td class="py-5">
										<div class="py-3 border-bottom border-top">
											<p class="mb-0 text-dark">$414.00</p>
										</div>
									</td>
								</tr>
								<tr>
									<th scope="row"></th>
									<td class="py-5">
										<p class="mb-0 text-dark py-4">적립금</p>
									</td>
									<td colspan="3" class="py-5">
										<button
											class="btn border-secondary rounded-pill px-3 py-2 text-primary"
											type="button">적립금 사용</button>
									</td>
								</tr>
								<tr>
									<th scope="row"></th>
									<td class="py-5">
										<p class="mb-0 text-dark text-uppercase py-3">TOTAL</p>
									</td>
									<td class="py-5"></td>
									<td class="py-5"></td>
									<td class="py-5">
										<div class="py-3 border-bottom border-top">
											<p class="mb-0 text-dark">$135.00</p>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div
						class="row g-4 text-center align-items-center justify-content-center border-bottom py-3">
						<div class="col-12">
							<div class="form-check text-start my-3">
								<input type="checkbox"
									class="form-check-input bg-primary border-0" id="Transfer-1"
									name="Transfer" value="Transfer"> <label
									class="form-check-label" for="Transfer-1">상기 주문내역을
									확인해주세요.</label>
							</div>
							<p class="text-start text-dark"></p>
						</div>
					</div>
					<div
						class="row g-4 text-center align-items-center justify-content-center pt-4">
						<button type="button"
							class="btn border-secondary py-3 px-4 text-uppercase w-100 text-primary">Place
							Order</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
