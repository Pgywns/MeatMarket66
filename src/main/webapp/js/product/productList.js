/**
 * productList.js 
 */

let prdSort = "df";

function renderProduct(product) {
	return `
		<div class="col-md-6 col-lg-6 col-xl-4">
			<div id="detail" class="rounded position-relative fruite-item border border-secondary">
				<div class="fruite-img">
					<a href="productDetail.do?prdSort=${product.prdSort}&prdNo=${product.prdNo}&prdImage=${product.prdImage}&prdName=${product.prdName}&prdPrice=${product.prdPrice}&prdContent=${product.prdContent}">
						<img src="img/productList/${product.prdSort}/${product.prdImage}" class="img-fluid w-100 rounded-top" alt="">
					</a>
				</div>
				<div class="text-white bg-secondary px-3 py-1 rounded position-absolute" style="top: 10px; left: 10px;">
					${product.prdSort}
				</div>
				<div class="p-4 border rounded-bottom">
					<h6>${product.prdName}</h6>
					<p>${product.prdContent}</p>
					<div class="d-flex justify-content-between flex-lg-wrap">
						<p class="text-dark fs-5 fw-bold mb-0">${product.prdPrice}원</p>
						<a onclick="javascript:productCart(${product.prdNo});" class="btn border border-secondary rounded-pill px-3 text-primary">
							<i class="fa fa-shopping-bag me-2 text-primary"></i>장바구니
						</a>
					</div>
				</div>
			</div>
		</div>`;
}

// 기능		
const svc = {
	// 상품 목록 (기본)
	// 상품 전체 리스트
	productList: async function(page) {
		try {
			const response = await fetch('productListPaging.do?page=' + page);
			const result = await response.json();
			document.querySelector('#pList').innerHTML = "";

			result.forEach(product => {
				let str = `<div class="col-md-6 col-lg-6 col-xl-4">
								<div id="detail" class="rounded position-relative fruite-item border border-secondary">
									<div class="fruite-img">
										<a href="productDetail.do?prdSort=${product.prdSort}&prdNo=${product.prdNo}&prdImage=${product.prdImage}&prdName=${product.prdName}&prdPrice=${product.prdPrice}&prdContent=${product.prdContent}">
											<img src="img/productList/${product.prdSort}/${product.prdImage}" class="img-fluid w-100 rounded-top" alt="">
										</a>
									</div>
									<div class="text-white bg-secondary px-3 py-1 rounded position-absolute" style="top: 10px; left: 10px;">${product.prdSort}</div>
									<div class="p-4 border rounded-bottom">
										<h6>${product.prdName}</h6>
										<p>${product.prdContent}</p>
										<div class="d-flex justify-content-between flex-lg-wrap">
											<p class="text-dark fs-5 fw-bold mb-0">${product.prdPrice}원</p>
											<a onclick="javascript:productCart(${product.prdNo});" id="cartbtn" class="btn border border-secondary rounded-pill px-3 text-primary">
												<i class="fa fa-shopping-bag me-2 text-primary"></i>장바구니
											</a>
										</div>
									</div>
								</div>
							</div>`;
				document.querySelector('#pList').insertAdjacentHTML('beforeend', str);
			});
		} catch (err) {
			console.error('상품 전체 리스트 오류:', err);
		}
	},

	// 카테고리별
	categoryList: async function(str) {
		try {
			const page = 1;
			const response = await fetch(`productCategory.do?page=${page}&prdSort=${str}`);
			const result = await response.json();

			document.querySelector('#pList').innerHTML = "";
			document.querySelector('#hidden').style.visibility = "visible";

			result.forEach(product => {
				let str = `<div class="col-md-6 col-lg-6 col-xl-4"> ... </div>`; // 동일한 렌더링 생략
				document.querySelector('#pList').insertAdjacentHTML('beforeend', str);
				prdSort = product.prdSort;
			});
		} catch (err) {
			console.error('카테고리별 목록 오류:', err);
		}
	},

	// 옵션 정렬
	optionList: function(page) {
		document.querySelector('#fruits').addEventListener('change', async function(e) {
			let order = e.target.value;
			if (order === 'choose') return;

			try {
				const response = await fetch(`productListOption.do?order=${order}&page=${page}&prdSort=${prdSort}`);
				const result = await response.json();

				document.querySelector('#pList').innerHTML = "";
				result.forEach(product => {

					let str1 = `<div class="col-md-6 col-lg-6 col-xl-4"> ... </div>`; // 생략
					document.querySelector('#pList').insertAdjacentHTML('beforeend', str1);
				});
			} catch (err) {
				console.error('옵션 정렬 오류:', err);
			}
		});
	},

					let str = `<div class="col-md-6 col-lg-6 col-xl-4">
								<div id="detail" class="rounded position-relative fruite-item border border-secondary">
									<div class="fruite-img">
										<a href="productDetail.do?prdSort=${product.prdSort}&prdNo=${product.prdNo}&prdImage=${product.prdImage}&prdName=${product.prdName}&prdPrice=${product.prdPrice}&prdContent=${product.prdContent}
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
											<a onclick="javascript:productCart(${product.prdNo});"
												class="btn border border-secondary rounded-pill px-3 text-primary"><i
												class="fa fa-shopping-bag me-2 text-primary"></i>장바구니</a>
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
	optionList(page) {
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
												<a href="productDetail.do?prdSort=${product.prdSort}&prdNo=${product.prdNo}&prdImage=${product.prdImage}&prdName=${product.prdName}&prdPrice=${product.prdPrice}&prdContent${product.prdContent}">
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
														<a onclick="javascript:productCart(${product.prdNo});"
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

	// 검색 리스트
	searchList: function(page) {
		document.querySelector("#search2").addEventListener('input', async function(e) {
			let keyword = e.target.value;
			try {
				const response = await fetch(`productSearch.do?keyword=${encodeURIComponent(keyword)}&page=${page}`);
				const result = await response.json();

				const list = document.querySelector('#pList');
				list.innerHTML = "";
				result.forEach(product => {
					list.insertAdjacentHTML('beforeend', renderProduct(product));
				});
			} catch (err) {
				console.error('검색 목록 오류:', err);
			}
		});
	}
,
	//리뷰 목록
	reviewList() {
		document.querySelector('').innerHTML = "";
	}

}//end svc

// 장바구니 등록  onclick="javascript:productCart(cart)
async function productCart(productNo) {
    let cartQty = 1;
    let prdNo = productNo;

	//재고확인
	let checkStock = await fetch('checkStock.do?prdNo=' + prdNo);
	let stock = await checkStock.text();
	
	if (stock == "guest") {
		alert("로그인 후 가능합니다.");
		return;
	} else if (stock == "admin") {
		alert("관리자 권한으로는 할 수 없습니다.");
		return;
	}
	
	let nowStock = parseInt(stock);
	if (cartQty > nowStock ) {
		alert("재고가 부족합니다. 현재 " + nowStock + "개까지 구매가능 합니다.");
		return; // 더 진행하지 않음
    }
	
    let data = await fetch("cart.do");
    let result = await data.json();

    let cartChk = result.some(cart => cart.prdNo == productNo);

    if (cartChk) {
        alert("장바구니에 이미 있습니다");
        return;
    } else {
		//countCartlist();	
	}

    let addCart = await fetch(`cartAdd.do?prdNo=${prdNo}&cartQty=${cartQty}`);
    let cartResult = await addCart.json();

    if (cartResult.retCode == 'Success') {
        alert("장바구니에 추가하였습니다.");
    } 
}