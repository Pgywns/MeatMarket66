<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
th {
	width: 150px;
}

input[type=file]::file-selector-button {
	margin-right: 50px;
}

input::-webkit-inner-spin-button {
  	-webkit-appearance: none;
  	margin: 0;
}
</style>
<div class="container-fluid page-header py-5">
	<h1 class="text-center text-white display-6">상품 등록</h1>
</div>

<div class="container-fluid py-5 mt-5">
	<div class="container py-5">
		<form method="post" enctype="multipart/form-data" onsubmit="javascript:addProduct(event);">
			<table class="table">
				<tr>
					<th>품명</th>
					<td><input type="text" class="form-control" name="pName" id="pName" required></td>
				</tr>
				<tr>
					<th>설명</th>
					<td><textarea class="form-control" name="pContent" id="pContent" required></textarea></td>
				</tr>
				<tr>
					<th>가격</th>
					<td><input type="number" class="form-control" name="pPrice" id="pPrice" required></td>
				</tr>
				<tr>
					<th>카테고리</th>
					<td><select name="pCategory" id="pCategory">
							<option value="돼지">돼지고기</option>
							<option value="소">소고기</option>
							<option value="닭">닭고기</option>
							<option value="밀키트">밀키트</option>
							<option value="채소류">채소</option>
					</select></td>
				</tr>
				<tr>
					<th>상품 사진</th>
					<td><input type="file" name="pFile" accept=".png, .jpg" id="pFile" required></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="등록">
						<input type="reset" value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
</div>
<script src="js/admin/addProduct.js"></script>