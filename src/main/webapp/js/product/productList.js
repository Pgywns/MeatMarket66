/**
 * productList.js 
 */
let page = 1;
let prdSort = "df";

// 기능		
const svc = {
	// 상품 목록 (기본)
	productList() {
		fetch('productListPaging.do?page=' + page)
			.then(response => response.json())
			.then(result => {
				result.forEach(product => {
					let str = `<div class="col-md-6 col-lg-6 col-xl-4">
								<div id="detail" class="rounded position-relative fruite-item border border-secondary">
									<div class="fruite-img">
										<a href="productDetail.do?prdSort=${product.prdSort}&prdImage=${product.prdImage}&prdName=${product.prdName}&prdPrice=${product.prdPrice}&prdContent=${product.prdContent}
											"><img src="img/productList/${product.prdSort}/${product.prdImage}"
											class="img-fluid w-100 rounded-top" alt=""></a>
									</div>
									<div
										class="text-white bg-secondary px-3 py-1 rounded position-absolute"
										style="top: 10px; left: 10px;">${product.prdSort}</div>
									<div class="p-4 border  rounded-bottom">
										<h6>${product.prdName}</h6>
										<p>${product.prdContent}</p>
										<div class="d-flex justify-content-between flex-lg-wrap">
											<p class="text-dark fs-5 fw-bold mb-0">${product.prdPrice}원</p>
											<a href=""
												class="btn border border-secondary rounded-pill px-3 text-primary"><i
												class="fa fa-shopping-bag me-2 text-primary"></i>장바구니
												</a>
										</div>
									</div>
								</div>
							</div>`;
					document.querySelector('#pList').insertAdjacentHTML('beforeend', str);
				})
			})
	},//end productList()

	//상품 목록 카테고리별
	categoryList(str) {
		fetch("productCategory.do?prdSort=" + str)
			.then(response => response.json())
			.then(result => {
				document.querySelector('#pList').innerHTML = "";
				document.querySelector('#hidden').style.visibility = "visible";
				result.forEach(product => {
					let str = `<div class="col-md-6 col-lg-6 col-xl-4">
								<div id="detail" class="rounded position-relative fruite-item border border-secondary">
									<div class="fruite-img">
										<a href="productDetail.do?prdSort=${product.prdSort}&prdImage=${product.prdImage}&prdName=${product.prdName}&prdPrice=${product.prdPrice}&prdContent=${product.prdContent}
											"><img src="img/productList/${product.prdSort}/${product.prdImage}"
											class="img-fluid w-100 rounded-top" alt=""></a>
									</div>
									<div
										class="text-white bg-secondary px-3 py-1 rounded position-absolute"
										style="top: 10px; left: 10px;">${product.prdSort}</div>
									<div class="p-4 border  rounded-bottom">
										<h6>${product.prdName}</h6>
										<p>${product.prdContent}</p>
										<div class="d-flex justify-content-between flex-lg-wrap">
											<p class="text-dark fs-5 fw-bold mb-0">${product.prdPrice}원</p>
											<a href=""
												class="btn border border-secondary rounded-pill px-3 text-primary"><i
												class="fa fa-shopping-bag me-2 text-primary"></i> Add to
												cart</a>
										</div>
									</div>
								</div>
							</div>`;
					document.querySelector('#pList').insertAdjacentHTML('beforeend', str);
					prdSort = product.prdSort;
				})
			})
	},//end categoryList

	// 가격 오름차순,내림차순별 목록
	optionList() {
		document.querySelector('#fruits').addEventListener('change', function(e) {
			let order = e.target.options[e.target.options.selectedIndex].value;
			console.log(order);
			if (order == "choose") {
				return;
			} else {
				fetch("productListOption.do?order=" + order + "&page=" + page + "&prdSort=" + prdSort)
					.then(res => res.json())
					.then(result => {
						document.querySelector('#pList').innerHTML = "";
						result.forEach(product => {
							let str1 = `<div class="col-md-6 col-lg-6 col-xl-4">
											<div class="rounded position-relative fruite-item border border-secondary">
												<div class="fruite-img">
												<a href="productDetail.do?prdSort=${product.prdSort}&prdImage=${product.prdImage}&prdName=${product.prdName}&prdPrice=${product.prdPrice}&prdContent${product.prdContent}">
													<img src="img/productList/${product.prdSort}/${product.prdImage}"
														class="img-fluid w-100 rounded-top" alt=""></a>
												</div>
												<div
													class="text-white bg-secondary px-3 py-1 rounded position-absolute"
													style="top: 10px; left: 10px;">${product.prdSort}</div>
												<div class="p-4 border  rounded-bottom">
													<h6>${product.prdName}</h6>
													<p>${product.prdContent}</p>
													<div class="d-flex justify-content-between flex-lg-wrap">
														<p class="text-dark fs-5 fw-bold mb-0">${product.prdPrice}원</p>
														<a href=""
															class="btn border border-secondary rounded-pill px-3 text-primary"><i
															class="fa fa-shopping-bag me-2 text-primary"></i>장바구니
															</a>
													</div>
												</div>
											</div>
										</div>`;
							document.querySelector('#pList').insertAdjacentHTML('beforeend', str1);
						})
					})
			}// end else
			console.log(prdSort);
		})
	},//end optionList

	// 목록 검색
	searchList() {
		document.querySelector("#search2").addEventListener('input', function(e) {
			let keyword = e.target.value;
			fetch("productSearch.do?keyword=" + keyword)
				.then(res => res.json())
				.then(result => {
					document.querySelector('#pList').innerHTML = "";
					result.forEach(product => {
						let str1 = `<div class="col-md-6 col-lg-6 col-xl-4">
									<div class="rounded position-relative fruite-item border border-secondary">
										<div class="fruite-img">
										<a href="productDetail.do?prdSort=${product.prdSort}&prdImage=${product.prdImage}&prdName=${product.prdName}&prdPrice=${product.prdPrice}&prdContent${product.prdContent}">
											<img src="img/productList/${product.prdSort}/${product.prdImage}"
												class="img-fluid w-100 rounded-top" alt=""></a>
										</div>
										<div
											class="text-white bg-secondary px-3 py-1 rounded position-absolute"
											style="top: 10px; left: 10px;">${product.prdSort}</div>
										<div class="p-4 border  rounded-bottom">
											<h6>${product.prdName}</h6>
											<p>${product.prdContent}</p>
											<div class="d-flex justify-content-between flex-lg-wrap">
												<p class="text-dark fs-5 fw-bold mb-0">${product.prdPrice}원</p>
												<a href=""
													class="btn border border-secondary rounded-pill px-3 text-primary"><i
													class="fa fa-shopping-bag me-2 text-primary"></i>장바구니
													</a>
											</div>
										</div>
									</div>
								</div>`;
						document.querySelector('#pList').insertAdjacentHTML('beforeend', str1);
					})
				})
		})
	},
	//리뷰 목록
	reviewList() {
		document.querySelector('').innerHTML = "";
	}

}//end svc

//회원아이디, 상품번호, 갯수(default 1)

svc.searchList();
svc.productList();
svc.optionList();
