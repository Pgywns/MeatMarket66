/**
 * 
 */
let prdSort = "";

document.addEventListener("DOMContentLoaded", function () {
    const productMeta = document.getElementById("detailImage");
    prdSort = productMeta.dataset.sort;
	prdNo = productMeta.dataset.no;
	
	if (prdSort == "밀키트") {
		detailMealkit();
	} else if (prdSort == "채소류") {
		detailVege();
	} else {
		detailIMeat();
	}
	
	review(prdNo);
});

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
	console.log(prdNo);
	fetch("detailReview.do?prdNo=" + prdNo)
	.then(data => data.json())
	.then(result => {
		result.forEach(review => {
			let str = `
					<div class="d-flex">
						<div class="">
							<p class="mb-2" style="font-size: 14px;">${review.rvwDate}</p>
							<div class="d-flex justify-content-between">
								<h5>${review.userId}</h5>
							</div>
							<p>${review.rvwContent}</p>
						</div>
					</div>
						`;
			
		document.querySelector('#reviewBox').insertAdjacentHTML('beforeend', str);
		})
	})
}
