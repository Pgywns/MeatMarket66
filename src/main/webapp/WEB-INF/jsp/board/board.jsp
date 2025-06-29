<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jsp->js -->	
<input type="hidden" id="loginUser" value="<%= session.getAttribute("userId") %>">
<div class="container-fluid page-header py-5">
	<h1 class="text-center text-white display-6">고객센터</h1>
</div>
<div class="container-fluid py-5 mt-5">
	<div class="container py-5">
		<!-- click이벤트 발생 -->
		<nav class="">
		<button class="btn btn-dark" id="insertBtn">1:1문의</button>
			<div class="nav nav-tabs mb-3 w-75" id="boardLis">
				<button class="nav-link active border-white border-bottom-0"
					type="button" role="tab" id="nav-about-tab" data-bs-toggle="tab"
					data-bs-target="#nav-about" aria-controls="nav-about"
					aria-selected="true" onclick="javascript:svc.btnClickList('상품');">상품관련</button>
				<button class="nav-link border-white border-bottom-0" type="button"
					role="tab" id="nav-mission-tab" data-bs-toggle="tab"
					data-bs-target="#nav-mission" aria-controls="nav-mission"
					aria-selected="false" onclick="javascript:svc.btnClickList('배송');">배송</button>
				<button class="nav-link border-white border-bottom-0" type="button"
					role="tab" id="nav-mission-tab" data-bs-toggle="tab"
					data-bs-target="#nav-mission" aria-controls="nav-mission"
					aria-selected="false" onclick="javascript:svc.btnClickList('포장');">포장</button>
				<button class="nav-link border-white border-bottom-0" type="button"
					role="tab" id="nav-mission-tab" data-bs-toggle="tab"
					data-bs-target="#nav-mission" aria-controls="nav-mission"
					aria-selected="false" onclick="javascript:svc.btnClickList('이벤트');">변경 / 취소 /반품</button>
				<button class="nav-link border-white border-bottom-0" type="button"
					role="tab" id="nav-mission-tab" data-bs-toggle="tab"
					data-bs-target="#nav-mission" aria-controls="nav-mission"
					aria-selected="false" onclick="javascript:svc.btnClickList('회원');">회원</button>
				<button class="nav-link border-white border-bottom-0" type="button"
					role="tab" data-bs-toggle="tab"
					data-bs-target="#nav-mission" aria-controls="nav-mission"
					aria-selected="false" id="userBtn">내 문의</button>
			</div>
		</nav>
	</div>
	<div class="container" id="boardCategory"></div>
</div>

<script src="js/board/board.js"></script>