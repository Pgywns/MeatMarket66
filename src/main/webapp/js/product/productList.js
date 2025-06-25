/**
 * productList.js 
 */

let page = 1;
const svc = {
	productList() {
		fetch('productList2.do?page='+page)
			.then(response => response.json())
			.then(result => {
				console.log(result);
				result.forEach(product => {
					let str = `<div class="col-md-6 col-lg-6 col-xl-4">
								<div class="rounded position-relative fruite-item border border-secondary">
									<div class="fruite-img">
										<img src="img/productList/${product.pSort}/${product.pImage}"
											class="img-fluid w-100 rounded-top" alt="">
									</div>
									<div
										class="text-white bg-secondary px-3 py-1 rounded position-absolute"
										style="top: 10px; left: 10px;">${product.pSort}</div>
									<div class="p-4 border  rounded-bottom">
										<h4>${product.pName}</h4>
										<p>${product.pContent}</p>
										<div class="d-flex justify-content-between flex-lg-wrap">
											<p class="text-dark fs-5 fw-bold mb-0">${product.price}원</p>
											<a href="#"
												class="btn border border-secondary rounded-pill px-3 text-primary"><i
												class="fa fa-shopping-bag me-2 text-primary"></i> Add to
												cart</a>
										</div>
									</div>
								</div>
							</div>`;
					document.querySelector('#pList').insertAdjacentHTML('beforeend', str);
				})
			})
	},//end productList();
	
	productCategory(){
		fetch("")
		let str1 = `<li>
						<div class="d-flex justify-content-between fruite-name">
							<a id="beef" href="#"><i class="fas fa-apple-alt me-2"></i>소고기</a> <span>(3)</span>
						</div>
					</li>`;
	}
	
	
}//end svc

svc.productList();