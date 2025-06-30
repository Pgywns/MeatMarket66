/**
 * 
 */

fetch("adminProductList.do")
	.then(data => data.json())
	.then(result => {
		result.forEach(product => {
			let str = `
			<tr class="main-row" onclick="toggleDetail(this)">
				<td>${product.prdNo }</td>
				<td>${product.prdName }</td>
				<td>${product.prdSort }</td>
				<td>${product.prdPrice }원</td>
				<td>${product.prdDate }</td>
			</tr>
			<tr class="detail-row">
				<td colspan="5">
					<div class="detail-content">
						<p>
							<strong>재고:</strong>
						</p>
						<div class="stock-control">
							<button onclick="changeStock(this, -1)">－</button>
							<span class="stock-count">${product.prdStock }</span>
							<button onclick="changeStock(this, 1)">＋</button>								
						</div>
						<p></p>
						<button onclick="confirmStock(${product.prdNo }, ${product.prdStock}, event)">확인</button>
					</div>
				</td>
			</tr>
		`;
		
		document.querySelector("#productBox").insertAdjacentHTML("beforeend", str);
		})
	})

function toggleDetail(row) {
	const detailRow = row.nextElementSibling;
	const content = detailRow.querySelector(".detail-content");
	content.classList.toggle("open");
}

function changeStock(button, delta) {
	const countEl = button.parentElement.querySelector(".stock-count");
	let current = parseInt(countEl.textContent, 10);
	let updated = current + delta;
	if (updated < 0)
		updated = 0; // 음수 방지
	countEl.textContent = updated;
}

function confirmStock(prdNo, prdStock, e) {
	let content = e.target.closest('.detail-content');
	let count = content.querySelector('.stock-count');
	let stock = parseInt(count.textContent);
	let result = 0;
	
	if (prdStock > stock) {
		result = (prdStock - stock) * -1;
	} else if (prdStock < stock) {
		result = stock - prdStock;
	}
	
	fetch("insertStock.do?prdNo=" + prdNo + "&prdStock=" + result)
	.then(data => data.json())
	.then(result => {
		if (result.retCode == 'Success') {
			alert("재고가 변경되었습니다.");
			location.reload();
		}
	})
}
