/*
* cart.js   fetch로 DB랑 연동필요. 기능만구현했음. 
*/

//페이지로드시 장바구니 목록출력
window.addEventListener('DOMContentLoaded', cartList);

let isCartEmpty = 'no'

function cartList() {
	fetch('cart.do') //frontcontroller
	.then(result => result.json())
	.then(data => {
		let cartItems = data;
		let basketBody = document.querySelector('#basketBody');
		for (let item of cartItems){
			let productList = makeTemplet(item);
			basketBody.insertAdjacentHTML("beforeend", productList);
		}
		//위치중요! 
		 updateTotal();
		 
		 if(!cartItems || cartItems.length === 0){
			isCartEmpty= 'yes';
		 }
	})
	.catch(err => console.log(err));
}

//장바구니check
function isCartEmptyCheck(){
	let checkbox = document.querySelector('#orderCheck');
		if (!checkbox.checked) {
			alert("상기 주문내역을 확인해주세요.");
			return; //미체크시 종료
		}
	
	if(isCartEmpty === 'yes'){
		alert("장바구니에 상품을 담아주세요.")
	} else{
	    location.href = 'order.do'; 
	}
}


//장바구니 상품 단건삭제(엑스btn)
function eachDel(event){
	let delbtn = event.target;
	let eachRow = delbtn.closest('.cartProduct');
	let prdNo = eachRow.querySelector('#selectdeProduct').value;
	fetch('cartPrdDel.do?prdNo='+prdNo)
	.then(() => {
			eachRow.remove();     // DOM에서 항목 제거
			countCartlist();      // 헤더 수량 업데이트
		})
	.catch(err => console.log(err));
}
//체크박스선택삭제
function checkedDel(){
	let checkedItems = document.querySelectorAll('input[name="selectdeProduct"]:checked'); //checked된것 모두 선택.[배열??list]

	    checkedItems.forEach(checked => { //checked 1개씩 꺼내서 DB삭제진행
	        let prdNo = checked.value;
	        // 개별 삭제 호출
	        fetch('cartPrdDel.do?prdNo='+prdNo)
			.then(() => {
					countCartlist();      // 헤더 수량 업데이트
			        checked.closest('.cartProduct').remove();
				})
	            .catch(err => console.error(err));
	    });
	    updateTotal();
}

//전체삭제
function delitem(){
	let cartBody = document.querySelector('#basketBody');
	fetch('cartEmpty.do')
	.then(() => {
			countCartlist();      // 헤더 수량 업데이트
		})
	.catch(err => console.log(err));
	cartBody.remove();
}

//장바구니수량변경
//수량변경
//0)재고조회
//1)+/-버튼수량변겅
function btnChange(event, upDown){
	let changeBtn = event.target;
	let eachRow = changeBtn.closest('.cartProduct');
	
	let qtyInput = eachRow.querySelector('#productQcy'); //value(수량) 디폴트 1. 
	//상품코드
	let prdNo = eachRow.querySelector('#selectdeProduct').value; 
	//수량
	let qty = parseInt(qtyInput.value); //입력된 수량가지고옴
	qty = Math.max(1, qty+upDown);  //수량변경
	qtyInput.value = qty; //변경된 수량 화면출력
	
	//재고 조회
	fetch('checkStock.do?prdNo=' + prdNo)
		.then(res => res.text())
		.then(data => {
			let stock = parseInt(data);

			if ( qty > (stock-1)) {   //현 재고에서 수량 못넘게
				alert("재고가 부족합니다.");
				return;
			}
		});
	
	//단가
	let unit = eachRow.querySelector('.unitPrice');
	let unitPrice = parseInt(unit.textContent);
	//단가*수량
	let totalTag = eachRow.querySelector('.totalTag')
	totalTag.textContent = (qty * unitPrice) + '원';
		
	fetch('cartUpdateQty.do?prdNo='+ prdNo +'&qty=' + qty)
	.catch(err => console.log(err));
	//총액
	updateTotal();
	
}

//2) 키보드입력 수량변경
function keyChange(event){   //숫자지우면 안됨... 오류!!!!!!!!! 수정할 것! 
	let keyQty = event.target;
	let eachRow = keyQty.closest('.cartProduct');
	//상품코드
	let prdNo = eachRow.querySelector('#selectdeProduct').value; 
	//단가
	let unit = eachRow.querySelector('.unitPrice');
	let unitPrice = parseInt(unit.textContent);
	//수량
	let qty = parseInt(keyQty.value);
	// NaN일 경우 처리
	if (isNaN(qty) || qty < 1) {
		alert("수량은 1개 이상 입력해야 합니다.");
		qty = 1; // 최소 1로 설정
	}
	keyQty.value = qty;
	
	//단가*수량
	let totalTag = eachRow.querySelector('.totalTag')
	totalTag.textContent = (qty * unitPrice) + '원';
	//DB반영
	fetch('cartUpdateQty.do?prdNo='+ prdNo +'&qty=' + qty)
	.catch(err => console.log(err));
	//총액
	updateTotal();
}

//총액계산
function updateTotal(){
	let total = 0;
	document.querySelectorAll('.totalTag').forEach(tag => {
	        let value = tag.textContent.replace(/\D/g, ''); // '원'삭제
	        total += parseInt(value);
	    });
	let totalEl = document.querySelector('.totalEl');
	totalEl.textContent = total.toLocaleString() + ' 원';
}


function makeTemplet(item){
		let tempelet = `
		<tr class="cartProduct">
			<th scope="row">
				<div class="d-flex align-items-center">
					<input type="checkbox" id="selectdeProduct" value="${item.prdNo}"
						name="selectdeProduct" /> <img src="img/productList/${item.prdSort}/${item.prdImage}"
						class="img-fluid me-5 rounded-circle "
						style="width: 80px; height: 80px;" alt=""/>
				</div>
			</th>
			<td>
				<p class="mb-0 mt-4">${item.prdName}</p>
			</td>
			<td>
				<p class="mb-0 mt-4 unitPrice">${item.prdPrice}</p>
			</td>
			<td>
				<div class="input-group quantity mt-4" style="width: 100px;">
					<div class="input-group-btn">
						<button
							class="btn btn-sm btn-minus rounded-circle bg-light border" onclick="btnChange(event, -1)">
							<i class="fa fa-minus" ></i>
						</button>
					</div>
					<input type="text" class="form-control form-control-sm text-center border-0" id="productQcy" value="${item.cartQty}" oninput="keyChange(event)"
						onblur="finalizeQty(event)" />
					<div class="input-group-btn">
						<button
							class="btn btn-sm btn-plus rounded-circle bg-light border" onclick="btnChange(event, 1)">
							<i class="fa fa-plus"></i>
						</button>
					</div>
				</div>
			</td>
			<td>
				<p class="mb-0 mt-4 totalTag">${item.prdPrice * item.cartQty} 원</p>
			</td>
			<td>
				<button id="delbtn" class="btn btn-md rounded-circle bg-light border mt-4" onclick="eachDel(event)">
					<i class="fa fa-times text-danger"></i>
				</button>
			</td>
		
		</tr>`;
	return tempelet;	
}

