<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="css/member/member.css" rel="stylesheet">
<link href="css/member/myPage.css" rel="stylesheet">

<div class="container-fluid page-header py-5"
	style="background-image: none; background-color: #81c408;">
	<h1 class="text-center text-white display-6">마이페이지</h1>
</div>

<div class="container-fluid py-5">
	<div class="mypage-container">
		<div class="user-name">${userName }님</div>

		<div class="summary-boxes">
			<div class="summary-item">
				<div>주문</div>
				<div>${totalOrder }건</div>
			</div>
			<div class="summary-item">
				<div>리뷰</div>
				<div>${totalReview }건</div>
			</div>
			<div class="summary-item">
				<div>적립금</div>
				<div>${totalPoint }원</div>
			</div>
			<div class="summary-item">
				<div>문의</div>
				<div>${totalBoard }건</div>
			</div>
		</div>

		<div class="menu-grid">
			<button type="button" class="menu-item"
				onclick="showSection('order')">주문내역</button>
			<button type="button" class="menu-item"
				onclick="showSection('point')">적립금내역</button>
			<button type="button" class="menu-item"
				onclick="showSection('review')">내 리뷰</button>
			<button type="button" class="menu-item"
				onclick="showSection('question')">내 질문</button>
			<button type="button" class="menu-item" onclick="showSection('info')">개인정보관리</button>
		</div>

		<!-- 표시될 영역들 -->
		<div class="section-content" id="order" style="display: block;">
			<h3>주문내역</h3>
			<table>
				<thead>
					<tr>
						<th>주문번호</th>
						<th>주소</th>
						<th>주문금액</th>
						<th>받으시는 분</th>
						<th>날짜</th>
						<th>리뷰</th>
					</tr>
				</thead>
				<tbody id="orderTable">
				</tbody>
			</table>
		</div>
		<div class="section-content" id="point" style="display: none;">
			<h3>적립금내역</h3>
			<table>
				<thead>
					<tr>
						<th>날짜</th>
						<th>내역</th>
					</tr>
				</thead>
				<tbody id="pointTable">
				</tbody>
			</table>
		</div>
		<div class="section-content" id="review" style="display: none;">
			<h3>내 리뷰</h3>
			<table id="reviewTotalTable">
				<thead>
					<tr>
						<th>상품</th>
						<th>리뷰번호</th>
						<th>내용</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody id="reviewTable">
				</tbody>
			</table>
		</div>
		<div class="section-content" id="question" style="display: none;">
			<h3>내 질문</h3>
			<table id="boardTotalTable">
				<thead>
					<tr>
						<th>번호</th>
						<th>카테고리</th>
						<th>제목</th>
						<th>내용</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody id="boardTable">
				</tbody>
			</table>
		</div>
		<div class="section-content" id="info" style="display: none;">
			<h3>개인정보관리</h3>
			<table id="userTable">
			</table>

			<h4>배송지 관리</h4>
			<div id="addressList">
				<table>
					<thead>
						<tr>
							<th>기본배송지</th>
							<th>배송지명</th>
							<th>우편번호</th>
							<th>주소</th>
							<th>삭제</th>
						</tr>
					</thead>	
					<tbody id="addressTable">				
					</tbody>
				</table>
			</div>
			<button class="btn-add" onclick="openPopUp('address', '배송지')">배송지 추가</button>
		</div>
	</div>
</div>

<!-- 모달 팝업 -->
<div id="popUp">
  <div id="modalBody">
    <span id="closeBtn" onclick="closePopUp()">&times;</span>
    <h3 id="modalTitle" style="margin-bottom: 20px;">정보 수정</h3>

    <label id="modalLabel" for="modalInput" style="display: block; margin-bottom: 10px;">값 입력</label>
    <input type="text" id="modalInput" style="width: 100%; padding: 10px; font-size: 16px;" />

    <!-- 비밀번호 확인용 input: 필요 시만 보이게 -->
    <input type="password" id="confirmPwInput" placeholder="비밀번호 확인"
      style="width: 100%; padding: 10px; font-size: 16px; margin-top: 10px; display: none;" 
      oninput="checkPwMatch()" />

    <!-- 비밀번호 일치 여부 메시지 -->
    <div id="pwMatchMsg" style="font-size: 14px; margin-top: 5px;"></div>
    
    <!-- 배송지 추가 입력 필드 (처음엔 숨김) -->
    <div id="addressInputs" style="display: none;">
     	<input type="text" id="addrName" name="addrName" class="form-control form-control-email" placeholder="배송지명" />
     	<input type="text" name="zipCode" class="zip" id="sample6_postcode" placeholder="우편번호" required readonly> 
		<button type="button" class="button-self" onclick="javascript:execDaumPostcode();">우편번호 찾기</button>
		<input type="text" name="addrOne" class="form-control form-control-email" id="sample6_address" placeholder="주소" required readonly> 
		<input type="text" name="addrTwo" class="form-control form-control-email" id="sample6_detailAddress" placeholder="상세주소" required>
    </div>
    <div style="margin-top: 30px; text-align: center;">
      <button onclick="confirmEdit()" style="padding: 10px 20px; background-color: #81c408; border: none; color: white; font-size: 16px; border-radius: 5px;">확인</button>
    </div>
  </div>
</div>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
window.onload = function () {
    showSection('order');
  };

  function showSection(sectionId) {
    // 모든 section-content 숨기기
    document.querySelectorAll('.section-content').forEach(el => {
      el.style.display = 'none';
    });

    // 선택한 section만 보이기
    document.getElementById(sectionId).style.display = 'block';
    
    // 만약 선택된 섹션이 'review'라면 리뷰 목록 불러오기
    if (sectionId === 'review') {
      selectReviews();
    } else if (sectionId === 'point') {
    	selectPoints();
    } else if (sectionId === 'info') {
    	selectUser();
    	selectAddress();
    } else if (sectionId === 'question') {
    	selectBoards();
    } else if (sectionId === 'order') {
    	selectOrders();
    }
  }
</script>
<script src="js/member/myPage.js"></script>