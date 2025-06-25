/*
* cart.js   fetch로 DB랑 연동필요. 기능만구현했음. 
*/



//페이지로드시 장바구니 목록출력
window.addEventListener('DOMContentLoaded', cartList);

function cartList() {
	fetch(`${CONTEXT_PATH}/cart.do`) //frontcontroller
	.then(result => result.json())
	.then(data => {
		console.log(data)
	})
	.catch(err => console.log(err));
}





//장바구니 상품목록출력
let basketBody = document.querySelector('#basketBody');
let productList = makeTemplet();
basketBody.insertAdjacentHTML("beforeend", productList);

function makeTemplet(){
		let tempelet = `
		<tr class="cartProduct">
			<th scope="row">
				<div class="d-flex align-items-center">
					<input type="checkbox" id="selectdeProduct"
						name="selectdeProduct" /> <img src="img/vegetable-item-3.png"
						class="img-fluid me-5 rounded-circle "
						style="width: 80px; height: 80px;" alt=""/>
				</div>
			</th>
			<td>
				<p class="mb-0 mt-4">Big Banana</p>
			</td>
			<td>
				<p class="mb-0 mt-4">3,000원</p>
			</td>
			<td>
				<div class="input-group quantity mt-4" style="width: 100px;">
					<div class="input-group-btn">
						<button
							class="btn btn-sm btn-minus rounded-circle bg-light border" onclick="btnChange(event, -1)">
							<i class="fa fa-minus" ></i>
						</button>
					</div>
					<input type="text"
						class="form-control form-control-sm text-center border-0"
						 id="productQcy" value="1" oninput="keyChange(event)"/> 
					<div class="input-group-btn">
						<button
							class="btn btn-sm btn-plus rounded-circle bg-light border" onclick="btnChange(event, 1)">
							<i class="fa fa-plus"></i>
						</button>
					</div>
				</div>
			</td>
			<td>
				<p class="mb-0 mt-4">2.99 $</p>
			</td>
			<td>
				<button id="delbtn" class="btn btn-md rounded-circle bg-light border mt-4" onclick="delitem(event)">
					<i class="fa fa-times text-danger"></i>
				</button>
			</td>
		
		</tr>`;
	return tempelet;	
}


//delbtn 상품목록 삭제버튼
function delitem(event){
	let delbtn = event.target;
	console.log(delbtn);
	delbtn.closest('.cartProduct').remove();
}


//전체삭제
function delAll(){
	document.querySelector('#basketBody').remove();
}

//수량변경
//1)+/-버튼수량변겅
function btnChange(event, upDown){
	let changeBtn = event.target;
	let row = changeBtn.closest('.cartProduct');
	let qtyValue = row.querySelector('#productQcy').value; //value 디폴트 1. 
	let qty = parseInt(qtyValue); 
	qty = Math.max(1, qty+upDown);
	console.log(qty);
	
}

//2) 키보드입력 수량변경
function keyChange(event){   //숫자지우면 안됨... 오류!!!!!!!!! 수정할 것! 
	let keyQty = event.target;
	console.log(keyQty);
	let qty = parseInt(keyQty.value);
	qty = Math.max(1, qty);  //입력구간지정. 
	keyQty.value = qty;
	console.log(keyQty.value);	
}

