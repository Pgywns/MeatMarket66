<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" href="./css/order/modalstyles.css" />

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
							<input type="radio" id="defaultAdd" name="address">
							<label for="defaultAdd">기본 배송지</label>
							<input type="radio" id="newtAdd" name="address" onclick="postApi()">
							<label for="newAdd">새로운 배송지 등록</label>
						</div>
						<div class="col-md-12 col-lg-6">
							<div class="form-item w-100">
								<label class="form-label my-3" id="sample6_postcode">우편번호<sup>*</sup></label> <input
									type="text" class="form-control">
							</div>
						</div>
						<div class="col-md-12 col-lg-6">
							<div class="form-item w-100">
								<label class="form-label my-3" id="sample6_address">주소<sup>*</sup></label> <input
									type="text" class="form-control">
							</div>
						</div>
						<div class="form-item">
							<label class="form-label my-3">상세주소<sup>*</sup></label> <input
								type="text" class="form-control"
								placeholder="상세주소">
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
							<tbody id="orderlist">
						    <!-- <tr>
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
								</tr> -->
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
								<!-- 모달영역 -->
									<td colspan="3" class="py-5">
									 <div>
										<button
											class="btn border-secondary rounded-pill px-3 py-2 text-primary"
											type="button" id="popBtn" onclick="modalPop()">적립금 사용</button>
									</div>
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
							class="btn border-secondary py-3 px-4 text-uppercase w-100 text-primary" onclick="location.href='complete.do'">Place
							Order</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>

<!-- 모달팝업 -->
<div id="popUp">
	<div id="modalBody">
		<span id="closeBtn">&times;</span>
		<P>모달내용</P>
	</div>
</div>
<!-- 모달영역end -->

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function postApi(){
	 new daum.Postcode({
         oncomplete: function(data) {
             // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

             // 각 주소의 노출 규칙에 따라 주소를 조합한다.
             // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
             var addr = ''; // 주소 변수


             //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
             if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                 addr = data.roadAddress;
             } else { // 사용자가 지번 주소를 선택했을 경우(J)
                 addr = data.jibunAddress;
             }
  
             // 우편번호와 주소 정보를 해당 필드에 넣는다.
             document.getElementById('sample6_postcode').value = data.zonecode;
             document.getElementById("sample6_address").value = addr;
             // 커서를 상세주소 필드로 이동한다.
             document.getElementById("sample6_detailAddress").focus();
         }
     }).open();
}
</script>
<script type="text/javascript" src="./js/order/order.js"></script>