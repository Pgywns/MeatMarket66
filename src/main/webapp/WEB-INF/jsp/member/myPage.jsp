<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<div>0건</div>
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
				<div>0건</div>
			</div>
		</div>

		<div class="menu-grid">
			<button type="button" class="menu-item" onclick="showSection('order')">주문내역</button>
			<button type="button" class="menu-item" onclick="showSection('point')">적립금내역</button>
			<button type="button" class="menu-item" onclick="showSection('review')">내 리뷰</button>
			<button type="button" class="menu-item" onclick="showSection('question')">내 질문</button>
			<button type="button" class="menu-item" onclick="showSection('info')">개인정보관리</button>
		</div>

		<!-- 표시될 영역들 -->
		<div class="section-content" id="order" style="display: block;">
			<h3>주문내역</h3>
			<p>여기에 주문내역이 표시됩니다.</p>
		</div>
		<div class="section-content" id="point" style="display: none;">
			<h3>적립금내역</h3>
			<p>여기에 적립금 내역이 표시됩니다.</p>
		</div>
		<div class="section-content" id="review" style="display: none;">
			<h3>내 리뷰</h3>
			<table>
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
			<p>여기에 내가 남긴 질문 목록이 표시됩니다.</p>
		</div>
		<div class="section-content" id="info" style="display: none;">
			<h3>개인정보관리</h3>
			<p>여기에 개인정보 수정/관리 내용이 표시됩니다.</p>
		</div>
	</div>
</div>

<script>
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
    }
  }
</script>
<script src="js/member/myPage.js"></script>