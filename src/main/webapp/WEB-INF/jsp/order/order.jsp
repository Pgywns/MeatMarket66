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
		<!-- 폼영역 -->
		<form action="#">
			<div class="row g-5">
				<div class="col-md-12 col-lg-6 col-xl-7">
					<div class="form-item">
						<label class="form-label my-3">받으시는 분<sup>*</sup></label> <input
							type="text" class="form-control" id="name">
					</div>
					<!-- 주소영역 -->
					<div class="row my-3">
						<div>
							<input type="radio" id="defaultAdd" name="address">
							<label for="defaultAdd" onclick="openAddressModal();">등록된 배송지 선택</label>
						</div>
						<div class="col-md-12 col-lg-6">
							<div class="form-item w-100">
								 <label class="form-label my-3">우편번호<sup>*</sup></label> <input
									type="text" class="form-control" id="sample6_postcode"> 
							</div>
						</div>
						<div class="col-md-12 col-lg-6">
							<div class="form-item w-100">
								<label class="form-label my-3" >주소<sup>*</sup></label> <input
									type="text" class="form-control" id="sample6_address">
							</div>
						</div>
						<div class="form-item">
							<label class="form-label my-3" >상세주소<sup>*</sup></label> <input
								type="text" class="form-control"
								placeholder="상세주소" id="addrTwo" >
						</div>
					</div>
					<div class="form-item">
						<label class="form-label my-3">연락처<sup>*</sup></label> <input
							type="tel" class="form-control" id="phone">
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
						   	<!-- 주문상품출력 -->
						   	<!-- 주문상품출력 -->
						   	<!-- 주문상품출력 -->
								<tr>
									<th scope="row"></th>
									<td class="py-5">
										<p class="mb-0 text-dark text-uppercase py-3">SUBTOTAL</p>
									</td>
									<td class="py-5"></td>
									<td class="py-5"></td>
									<td class="py-5">
										<div class="py-3 border-top border-bottom">
											<p class="mb-0 text-dark subTotal">100,000원</p>
										</div>
									</td>
								</tr>
								<tr>
									<th scope="row"></th>
									<td colspan="2" class="py-5 align-middle">
										<button
											class="btn border-secondary rounded-pill px-3 py-2 text-primary"
											type="button" id="popBtn" onclick="myPointCheck(); modalPop();">
											적립금 사용</button>
									</td>
									<td class="py-5 align-middle">
										<p class="mb-0 text-dark">사용적립금</p>
									</td>
									<td class="py-5 align-middle">
										<p id="myPointPreview" class="mb-0 text-secondary">0 P</p>
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
										<div class="py-3 border-bottom border-top" id="amount">
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
							class="btn border-secondary py-3 px-4 text-uppercase w-100 text-primary" onclick="submitOrderForm()">Place
							Order</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>


<!-- 배송지 선택 모달 -->
<div id="addressPopUp" class="modal">
  <div id="addressModalBody" class="modal-body">
    <span id="addressCloseBtn" class="close">&times;</span>

    <div class="mb-4">
      <p class="fw-bold fs-5 mb-2">등록된 배송지 목록</p>
      <div id="addressList">
        <!-- 주소 목록을 자바스크립트로 삽입 -->
      </div>
    </div>
  </div>
</div>

<!-- 모달팝업 -->
<div id="popUp">
  <div id="modalBody">
    <span id="closeBtn">&times;</span>

    <div class="mb-4">
      <p class="fw-bold fs-5 mb-2">나의 적립금</p>
      <p id="myPoint" class="text-secondary">10,000P</p>
    </div>

    <div class="mb-4">
      <label for="usePoint" class="form-label">사용할 적립금</label>
      <input type="number" id="usePoint" class="form-control" placeholder="1,000원 단위로 사용할 수 있습니다." min="0" value=""/>
    </div>

    <div class="text-end">
      <button
        class="btn border-secondary rounded-pill px-3 py-2 text-primary"
        type="button"
        onclick="usePoint()"
      >
        사용하기
      </button>
    </div>
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
             /* document.getElementById("sample6_detailAddress").focus(); */
         }
     }).open();
}
</script>
<script type="text/javascript" src="./js/order/order.js"></script>