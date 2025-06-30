<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: 'Noto Sans KR', sans-serif;
	background-color: #f5f5f5;
	margin: 0;
}

.review-box {
	background: #fff;
	border: 1px solid #e0e0e0;
	border-radius: 8px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	padding: 30px;
	max-width: 720px;
	margin: 40px auto;
}

.review-box h3 {
	font-size: 24px;
	color: #333;
	margin-bottom: 25px;
	border-left: 4px solid #4CAF50;
	padding-left: 10px;
}

.review-box label {
	display: block;
	margin: 15px 0 8px;
	font-weight: 600;
	color: #555;
	font-size: 14px;
}

.review-box input[type="text"], .review-box textarea {
	width: 100%;
	padding: 12px 15px;
	border: 1px solid #ccc;
	border-radius: 4px;
	font-size: 14px;
	transition: all 0.3s;
}

.review-box input[type="text"]:focus, .review-box textarea:focus {
	border-color: #4CAF50;
	box-shadow: 0 0 5px rgba(76, 175, 80, 0.3);
	outline: none;
}

.review-box textarea {
	height: 120px;
	resize: vertical;
}

.review-box .submit-btn {
	background: #4CAF50;
	color: #fff;
	border: none;
	padding: 14px 25px;
	cursor: pointer;
	font-size: 16px;
	border-radius: 4px;
	margin-top: 20px;
	transition: background 0.3s;
	width: 100%;
}

.review-box .submit-btn:hover {
	background: #43A047;
}

.purchase-info {
	font-size: 13px;
	color: #999;
	margin-top: 15px;
	text-align: right;
}
</style>

<%
	String prdName = request.getParameter("prdName");
	request.setAttribute("prdName", prdName);
	
	String prdNo = request.getParameter("prdNo");
	request.setAttribute("prdNo", prdNo);
%>

<div class="container-fluid page-header py-5">
	<h1 class="text-center text-white display-6">Review</h1>
</div>
<div class="container-fluid py-5">
	<div class="container">
		<div class="review-box">
			<h3>상품 리뷰 작성</h3>

			<form method="post" action="addReview.do" enctype="multipart/form-data">
				<input type="hidden" name="prdNo" id="prdNo" value="${prdNo }" />
				<label for="prdName">상품</label>
				<input type="text" id="prdName" name="prdName" value="${prdName }" readonly/>
				<label for="userName">이름</label>
				<input type="text" id="userName" name="userName" value="${userName }" readonly/> 
				<label for="content">리뷰 내용</label>
				<textarea id="content" name="content" placeholder="예) 신선하고 맛있네요 ^^" required></textarea>
				<input type="file" name="prdImage" accept=".png, .jpg" id="prdImage" required style="margin-top: 15px;">
				<button type="submit" class="submit-btn">리뷰 등록</button>
			</form>

			<div class="purchase-info">※ 작성하신 리뷰는 상품 정보에 노출됩니다.</div>
		</div>
	</div>
</div>