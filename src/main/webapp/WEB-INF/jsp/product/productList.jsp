<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- Single Page Header start -->

<div class="container-fluid page-header py-5">
	<h1 class="text-center text-white display-6">Shop List</h1>
	
</div>
<!-- Single Page Header End -->

<!-- Fruits Shop Start-->
<div class="container-fluid fruite py-5">
	<div class="container py-5">
		<h1 class="mb-4">탱탱한 상품들</h1>
		<div class="row g-4">
			<div class="col-lg-12">
				<div class="row g-4">
					<div class="col-xl-3">
						<div class="input-group w-100 mx-auto d-flex">
							<input type="search" class="form-control p-3"
								placeholder="keywords" aria-describedby="search-icon-1">
							<span id="search-icon-1" class="input-group-text p-3"><i
								class="fa fa-search"></i></span>
						</div>
					</div>
					<div class="col-6"></div>
					<div class="col-xl-3">
						<div class="bg-light ps-3 py-3 rounded d-flex justify-content-between mb-4">
							<label for="fruits">정렬 순서:</label> <select id="fruits"
								name="fruitlist" class="border-0 form-select-sm bg-light me-3"
								form="fruitform">
								<option value="beef">높은 가격순</option>
								<option value="pork">낮은 가격순</option>
								<option value="chicken">등록일순</option>
								<option value="vegetable">채소</option>
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
										<li>
											<div class="d-flex justify-content-between fruite-name">
												<a id="beef" href="#"><i class="fas fa-apple-alt me-2"></i>소고기</a> <span>(3)</span>
											</div>
										</li>
										<li>
											<div class="d-flex justify-content-between fruite-name">
												<a id="pork" href="#"><i class="fas fa-apple-alt me-2"></i>돼지고기</a> <span>(5)</span>
											</div>
										</li>
										<li>
											<div class="d-flex justify-content-between fruite-name">
												<a id="chicken" href="#"><i  class="fas fa-apple-alt me-2"></i>닭고기</a> <span>(2)</span>
											</div>
										</li>
										<li>
											<div class="d-flex justify-content-between fruite-name">
												<a  id="vege" href="#"><i class="fas fa-apple-alt me-2"></i>채소</a> <span>(8)</span>
											</div>
										</li>
										<li>
											<div class="d-flex justify-content-between fruite-name">
												<a id="kit" href="#"><i class="fas fa-apple-alt me-2"></i>밀키트</a> <span>(5)</span>
											</div>
										</li>
									</ul>
								</div>
							</div>
							<div class="col-lg-12"></div>
							<div class="col-lg-12">
								<div class="position-relative">
									<img src="img/육월육일_side.png"
										class="img-fluid w-100 rounded" alt="">
									<div class="position-absolute"
										style="top: 50%; right: 10px; transform: translateY(-50%);">
									</div>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="position-relative">
									<img src="img/신선고기.jpg"
										class="img-fluid w-100 rounded" alt="">
									<div class="position-absolute"
										style="top: 50%; right: 10px; transform: translateY(-50%);">
										
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
								<a href="#" class="rounded">&laquo;</a>
								<a href="#" class="active rounded">1</a> <a href="#" class="rounded">2</a>
								<a href="#" class="rounded">3</a> <a href="#" class="rounded">4</a>
								<a href="#" class="rounded">5</a> <a href="#" class="rounded">6</a>
								<a href="#" class="rounded">&raquo;</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="js/product/productList.js"></script>
<!-- Fruits Shop End-->

