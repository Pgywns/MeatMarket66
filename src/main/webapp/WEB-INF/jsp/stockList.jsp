<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
table {
	width: 80%;
	margin: 20px auto;
	border-collapse: collapse;
	font-family: sans-serif;
}

th, td {
	border: 1px solid #ccc;
	padding: 12px;
	text-align: center;
}

tr.main-row {
	cursor: pointer;
	background-color: #f9f9f9;
}

tr.detail-row td {
	background-color: #f1f1f1;
	padding: 0;
}

.detail-content {
	max-height: 0;
	overflow: hidden;
	transition: max-height 0.4s ease;
	padding: 0 10px;
}

.detail-content.open {
	max-height: 200px;
	padding: 15px 10px;
}

.stock-control {
	display: flex;
	justify-content: center;
	align-items: center;
	gap: 10px;
	margin-top: 10px;
}

.stock-control button {
	padding: 6px 12px;
	font-size: 16px;
	cursor: pointer;
}

.stock-count {
	font-size: 18px;
	min-width: 30px;
}
</style>

<div class="container-fluid page-header py-5">
	<h1 class="text-center text-white display-6">상품 목록</h1>
</div>
<div class="container-fluid py-3 mt-3">
	<div class="container">
		<table>
			<thead>
				<tr>
					<th>상품 번호</th>
					<th>상품명</th>
					<th>분류</th>
					<th>가격</th>
					<th>등록일자</th>
				</tr>
			</thead>
			<tbody id="productBox">
				<!-- 상품 행 -->
				
			</tbody>
		</table>
	</div>
</div>
<script src="js/product/stock.js"></script>