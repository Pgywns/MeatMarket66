/**
 * 
 */
let prdSort = document.querySelector("#prdSort").value;
let prdNo = document.querySelector("#prdNo").value;

if (prdSort == "밀키트") {
	detailMealkit();
} else if (prdSort == "채소류") {
	detailVege();
} else {
	detailIMeat();
}

review(prdNo);

// 돼지, 소, 닭
function detailIMeat() {

	let str = `
	<img src="img/productDetail/${prdSort}/Main.png"
		class="img-fluid rounded" alt="Image"> <img
		src="img/productDetail/${prdSort}/1.png"
		class="img-fluid rounded" alt="Image"> <img
		src="img/productDetail/${prdSort}/2.png"
		class="img-fluid rounded" alt="Image"> <img
		src="img/productDetail/${prdSort}/3.png"
		class="img-fluid rounded" alt="Image"> <img
		src="img/productDetail/${prdSort}/4.png"
		class="img-fluid rounded" alt="Image"> <img
		src="img/productDetail/${prdSort}/5.png"
		class="img-fluid rounded" alt="Image"> <img
		src="img/productDetail/${prdSort}/6.png"
		class="img-fluid rounded" alt="Image">
	`;

	document.querySelector('#detailImage').insertAdjacentHTML('beforeend', str);
}

// 밀키트
function detailMealkit() {
	let str = `
		<img src="img/productDetail/${prdSort}/Main.png"
			class="img-fluid rounded" alt="Image"> <img
			src="img/productDetail/${prdSort}/1.png"
			class="img-fluid rounded" alt="Image"> <img
			src="img/productDetail/${prdSort}/2.png"
			class="img-fluid rounded" alt="Image"> <img
			src="img/productDetail/${prdSort}/3.png"
			class="img-fluid rounded" alt="Image">
		`;

	document.querySelector('#detailImage').insertAdjacentHTML('beforeend', str);
}

// 채소류
function detailVege() {
	let str = `
			<img src="img/productDetail/${prdSort}/Main.png"
				class="img-fluid rounded" alt="Image"> <img
				src="img/productDetail/${prdSort}/1.png"
				class="img-fluid rounded" alt="Image"> <img
				src="img/productDetail/${prdSort}/2.png"
				class="img-fluid rounded" alt="Image">
			`;

	document.querySelector('#detailImage').insertAdjacentHTML('beforeend', str);
}

function review(prdNo) {
	fetch("detailReview.do?prdNo=" + prdNo)
		.then(data => data.json())
		.then(result => {
			let reviewNum = result.length;
			if (result.length == 0) {

				let str = `
					<div class="d-flex">
						<h5>리뷰가 없습니다.</h5>
					</div>
						`;

				document.querySelector('#reviewBox').insertAdjacentHTML('beforeend', str);
				document.querySelector('#reviewNum').textContent = " (" + reviewNum + ")";
			} else {
				result.forEach(review => {
					let str = `
						<div class="d-flex">
							<div class="">
								<p class="mb-2" style="font-size: 14px;">${review.rvwDate}</p>
								<div class="d-flex justify-content-between">
									<h5 style="font-family: none;">${review.userId}</h5>
								</div>
								<p>${review.rvwContent}</p>
							</div>
						</div>
						<img src="img/review/${review.rvwImage}" style="width:300px; height:300px; margin-bottom: 80px;"/>
							`;

					document.querySelector('#reviewBox').insertAdjacentHTML('beforeend', str);
				})
				document.querySelector('#reviewNum').textContent = " (" + reviewNum + ")";
			}
		})
}

async function addCart(orderChk) {
	let prdQty = parseInt(document.querySelector("#prdQty").value);

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
	if (prdQty > nowStock ) {
		alert("재고가 부족합니다. 현재 " + nowStock + "개까지 구매가능 합니다.");
		return; // 더 진행하지 않음
    }
	
	let data = await fetch("cart.do");
    let result = await data.json();

    let cartChk = result.some(cart => cart.prdNo == prdNo);

    if (cartChk) {
		alert("장바구니에 이미 있습니다");
		return;
    } else {
		countCartlist();	
	}
	
	let addCart = await fetch(`cartAdd.do?prdNo=${prdNo}&cartQty=${prdQty}`);
	let cartResult = await addCart.json();

	if (cartResult.retCode == 'Success') {
		if (orderChk == 'cart') {
			alert("장바구니에 추가하였습니다.");
			location.reload();
			countCartlist()//장바구니아이콘 수량변경
		} else if (orderChk == 'order') {
			window.location.href = "cartPage.do";
		}
	} 
}

let price = document.querySelector('#prdPrice');
let price1 = Number(price.textContent).toLocaleString();
price.textContent = price1 + "원";