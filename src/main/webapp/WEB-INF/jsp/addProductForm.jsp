<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
th {
	width: 150px;
}

input[type=file]::file-selector-button {
	margin-right: 50px;
}
</style>
<div class="container-fluid page-header py-5">
</div>

<div class="container-fluid py-5 mt-5">
	<div class="container py-5">
		<form action="addProductForm.do" method="post">
			<input type="hidden" class="form-control" name="writer" value="">
			<table class="table">
				<tr>
					<th>품명</th>
					<td><input type="text" class="form-control" required
						name="p_name"></td>
				</tr>
				<tr>
					<th>설명</th>
					<td><textarea class="form-control" required name="p_content"></textarea></td>
				</tr>
				<tr>
					<th>가격</th>
					<td><input type="number" class="form-control" required
						name="price"></td>
				</tr>
				<tr>
					<th>카테고리</th>
					<td><select name="category" id="category">
							<option value="pork">돼지고기</option>
							<option value="beef">소고기</option>
							<option value="chicken">닭고기</option>
							<option value="mealkit">밀키트</option>
							<option value="vegetable">채소</option>
					</select></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="file"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="등록">
						<input type="reset" value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
</div>