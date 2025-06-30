<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
/* 네가 작성한 스타일 유지하되 body, html 태그에 주는 스타일은 제거해라 */
table {
	width: 100%;
	border-spacing: 0;
	border-collapse: collapse;
}

th, td {
	padding: 12px;
	text-align: left;
	vertical-align: middle;
}

th {
	width: 120px;
	background-color: #f9f9f9;
	color: #333;
	font-weight: normal;
}

input[type="text"], input[type="email"], textarea {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	box-sizing: border-box;
	font-size: 14px;
}

textarea {
	resize: vertical;
	min-height: 120px;
}

.btns {
	text-align: center;
	margin-top: 30px;
}

.btns button {
	padding: 10px 25px;
	margin: 0 10px;
	border: none;
	background-color: #8BC34A;
	color: #fff;
	font-size: 14px;
	cursor: pointer;
	border-radius: 4px;
}

.btns button.cancel {
	background-color: #999;
}

.category-toggle {
	display: flex;
	gap: 10px;
	flex-wrap: wrap;
	margin-top: 10px;
}

.category-toggle input[type="radio"] {
	display: none;
}

.category-toggle label {
	padding: 8px 15px;
	border: 1px solid #8BC34A;
	border-radius: 20px;
	cursor: pointer;
	background-color: #f0f9e9;
	color: #4a7c1a;
	user-select: none;
	transition: all 0.3s ease;
}

.category-toggle input[type="radio"]:checked+label {
	background-color: #8BC34A;
	color: white;
	font-weight: bold;
	border-color: #5a9b17;
}
</style>
<div class="container-fluid page-header py-5">
	<h1 class="text-center text-white display-6">1:1문의</h1>
</div>
<div class="container-fluid py-5 mt-5">
	<div class="container">
		<form action="${pageContext.request.contextPath}/boardinsert.do"
			method="POST">
			<table>
				<tr>
					<th>사용자 ID</th>
					<td><input type="text" name="userId" value="${userId}"
						readonly /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="boardTitle"
						placeholder="문의 제목을 입력하세요." required /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="boardContent" placeholder="문의 내용을 입력하세요."
							required></textarea></td>
				</tr>
				<tr>
					<th>카테고리</th>
					<td>
						<div class="category-toggle">
							<input type="radio" id="cat1" name="boardCategory" value="상품"
								checked> <label for="cat1">상품</label> <input
								type="radio" id="cat2" name="boardCategory" value="배송">
							<label for="cat2">배송</label> <input type="radio" id="cat3"
								name="boardCategory" value="포장"> <label for="cat3">포장</label>

							<input type="radio" id="cat4" name="boardCategory"
								value="변경/취소/반품"> <label for="cat4">변경/취소/반품</label> <input
								type="radio" id="cat5" name="boardCategory" value="회원">
							<label for="cat5">회원</label>
						</div>
					</td>
				</tr>
			</table>
			<div class="btns">
				<button type="submit">등록</button>
				<button type="button" class="cancel"
					onclick="location.href='board.do'">취소</button>
			</div>
		</form>
	</div>
</div>
