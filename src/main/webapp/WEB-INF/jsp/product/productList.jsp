<%@page import="java.util.List"%>
<%@page import="com.yedam.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Single Page Header start -->
<input type="hidden" name="keyword" value="${search.keyword}">
<input type="hidden" name="page" value="${search.page}">
<style>
#hidden {
	visibility: hidden;
}
</style>

<div class="container-fluid page-header py-5">
	<h1 class="text-center text-white display-6">Shop List</h1>

</div>
<!-- Single Page Header End -->

<!-- Fruits Shop Start-->
<div class="container-fluid fruite py-5">
	<div class="container py-5">
		<h1 class="mb-4">당신을 감동시킬 상품</h1>
		<div class="row g-4">
			<div class="col-lg-12">
				<div class="row g-4">
					<div class="col-xl-3">
						<div class="input-group w-100 mx-auto d-flex">
							<input type="search" id="search2" class="form-control p-3"
								placeholder="검색어를 입력하세요." aria-describedby="search-icon-1">
							<span id="search-icon-1" class="input-group-text p-3"><i
								class="fa fa-search"></i></span>
						</div>
					</div>
					<div class="col-6"></div>
					<div class="col-xl-3">
						<div id="hidden"
							class="bg-light ps-3 py-3 rounded d-flex justify-content-between mb-4"
							style="display: none">
							<label for="fruits">정렬 순서:</label> <select id="fruits"
								name="fruitlist" class="border-0 form-select-sm bg-light me-3"
								form="fruitform">
								<option value="choose">선택하세요</option>
								<option value="desc">높은 가격순</option>
								<option value="asc">낮은 가격순</option>
							</select>
						</div>
					</div>
				</div>
				<div class="row g-4">
					<div class="col-lg-3">
						<div class="row g-4">
							<div class="col-lg-12">
								<div class="mb-3">
									<h4>카테고리</h4>
									<ul class="list-unstyled fruite-categorie">
										<c:forEach var="item" items="${cList }">
											<li>
												<div class="d-flex justify-content-between fruite-name">
													<a 
														onclick="javascript:svc.categoryList('${item.prdSort}')"><i
														class="fas fa-apple-alt me-2"></i>${item.prdSort }</a> <span>${item.prdCount }</span>
												</div>
											</li>
										</c:forEach>
									</ul>
								</div>
							</div>
							<div class="col-lg-12"></div>
							<div class="col-lg-12">
								<div class="position-relative">
									<img src="img/육월육일_side.png" class="img-fluid w-100 rounded"
										alt="">
									<div class="position-absolute"
										style="top: 50%; right: 10px; transform: translateY(-50%);">
									</div>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="position-relative">
									<img src="img/신선고기.jpg" class="img-fluid w-100 rounded" alt="">
									<div class="position-absolute"
										style="top: 50%; right: 10px; transform: translateY(-50%);">
									</div>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="position-relative">
									<img src="img/돈미스.jpg" class="img-fluid w-100 rounded" alt="">
									<div class="position-absolute"
										style="height: 182px; top: 30%; right: 10px; transform: translateY(-50%);">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-9">
						<div id="pList" class="row g-4 justify-content-center">
							<!-- 페이징 -->

						</div>
						<div class="col-12">
							<div class="pagination d-flex justify-content-center mt-5">
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="js/product/productList.js"></script>
<script src="js/product/productPage.js"></script>
<!-- Fruits Shop End-->

