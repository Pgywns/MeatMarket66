<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
.rounded {
	margin: 0 auto;
	display: block;
	margin-bottom: 5px;
}
</style>
<!-- Single Page Header start -->
<div class="container-fluid page-header py-5">
	<h1 class="text-center text-white display-6">Shop Detail</h1>
</div>
<!-- Single Page Header End -->

<!-- Single Product Start -->
<div class="container-fluid py-5 mt-5">
	<div class="container py-5">
		<div class="row g-4 mb-5">
			<div>
				<div class="row g-4">
					<div class="col-lg-6">
						<div class="border rounded">
							<img src="img/productList/${prdSort }/${prdImage }"
								class="img-fluid rounded" alt="Image">
						</div>
					</div>
					<div class="col-lg-6 d-flex flex-column">
						<h4 class="fw-bold mb-3 mt-3" style="font-size: 30px;">${prdName }</h4>
						<p class="mb-3 mt-2" style="font-size: 20px;">Category:
							${prdSort }</p>
						<h5 class="fw-bold mb-4 mt-2" style="font-size: 28px;">${prdPrice }원</h5>
						<p class="mb-4" style="font-size: 20px;">${prdContent }</p>

						<div class="input-group quantity mt-5"
							style="width: 100px; margin: 0 auto;">
							<div class="input-group-btn">
								<button
									class="btn btn-sm btn-minus rounded-circle bg-light border">
									<i class="fa fa-minus"></i>
								</button>
							</div>
							<input type="text"
								class="form-control form-control-sm text-center border-0"
								value="1">
							<div class="input-group-btn">
								<button
									class="btn btn-sm btn-plus rounded-circle bg-light border">
									<i class="fa fa-plus"></i>
								</button>
							</div>
						</div>

						<a href="#"
							class="btn border border-secondary rounded-pill px-4 py-2 text-primary mt-3">
							<i class="fa fa-shopping-bag me-2 text-primary"></i> 장바구니
						</a> <a href="#"
							class="btn border border-secondary rounded-pill px-4 py-2 text-primary mt-3">
							구매하기 </a>
					</div>
					<div class="col-lg-12">
						<nav>
							<div class="nav nav-tabs mb-3">
								<button class="nav-link active border-white border-bottom-0"
									type="button" role="tab" id="nav-about-tab"
									data-bs-toggle="tab" data-bs-target="#nav-about"
									aria-controls="nav-about" aria-selected="true">About</button>
								<button class="nav-link border-white border-bottom-0"
									type="button" role="tab" id="nav-mission-tab"
									data-bs-toggle="tab" data-bs-target="#nav-mission"
									aria-controls="nav-mission" aria-selected="false">Reviews</button>
							</div>
						</nav>
						<div class="tab-content mb-5">
							<div class="tab-pane active" id="nav-about" role="tabpanel"
								aria-labelledby="nav-about-tab">
								<div class="px-2" id="detailImage" data-sort="${prdSort}">					
								</div>
							</div>
							<div class="tab-pane" id="nav-mission" role="tabpanel"
								aria-labelledby="nav-mission-tab">
								<!-- 리뷰쓰기 -->
								<div class="d-flex" id="reviewBox">
										
									<div class="">
										<p class="mb-2" style="font-size: 14px;">April 12, 2024</p>
										<div class="d-flex justify-content-between">
											<h5>Jason Smith</h5>
										</div>
										<p>The generated Lorem Ipsum is therefore always free from
											repetition injected humour, or non-characteristic words etc.
											Susp endisse ultricies nisi vel quam suscipit</p>
									</div>
								</div>
							</div>
							<div class="tab-pane" id="nav-vision" role="tabpanel">
								<p class="text-dark">Tempor erat elitr rebum at clita. Diam
									dolor diam ipsum et tempor sit. Aliqu diam amet diam et eos
									labore. 3</p>
								<p class="mb-0">Diam dolor diam ipsum et tempor sit. Aliqu
									diam amet diam et eos labore. Clita erat ipsum et lorem et sit</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-xl-3"></div>
		</div>
	</div>
</div>
<!-- Single Product End -->
<script src="js/product/productDetail.js">
	const prdSort = "${prdSort}";
</script>