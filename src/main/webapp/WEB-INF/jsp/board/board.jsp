<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-fluid py-5 mb-5 hero-header">
	<div class="board-container">
	<h2>고객 센터</h2>
			<!-- click이벤트 발생 -->
			<nav>
				<div class="nav nav-tabs mb-3">
					<button class="nav-link active border-white border-bottom-0"
						type="button" role="tab" id="nav-about-tab" data-bs-toggle="tab"
						data-bs-target="#nav-about" aria-controls="nav-about"
						aria-selected="true">상품관련</button>
					<button class="nav-link border-white border-bottom-0" type="button"
						role="tab" id="nav-mission-tab" data-bs-toggle="tab"
						data-bs-target="#nav-mission" aria-controls="nav-mission"
						aria-selected="false">주문/결제</button>
					<button class="nav-link border-white border-bottom-0" type="button"
						role="tab" id="nav-mission-tab" data-bs-toggle="tab"
						data-bs-target="#nav-mission" aria-controls="nav-mission"
						aria-selected="false">배송</button>
					<button class="nav-link border-white border-bottom-0" type="button"
						role="tab" id="nav-mission-tab" data-bs-toggle="tab"
						data-bs-target="#nav-mission" aria-controls="nav-mission"
						aria-selected="false">변경 / 취소 /반품</button>
					<button class="nav-link border-white border-bottom-0" type="button"
						role="tab" id="nav-mission-tab" data-bs-toggle="tab"
						data-bs-target="#nav-mission" aria-controls="nav-mission"
						aria-selected="false">회원정보</button>
					<button class="nav-link border-white border-bottom-0" type="button"
						role="tab" id="nav-mission-tab" data-bs-toggle="tab"
						data-bs-target="#nav-mission" aria-controls="nav-mission"
						aria-selected="false">내 문의</button>
				</div>
			</nav>
	</div>
	<div class="container" id="boardCategory">
		
	</div>
</div>
<script type="text/javascript" src="./js/board/board.js"></script>