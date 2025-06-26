/*
* cart.js   fetch로 DB랑 연동필요. 기능만구현했음. 
*/

//페이지로드시 장바구니 목록출력
window.addEventListener('DOMContentLoaded', cartList);

function cartList() {
	let value = "basic";
	fetch('cart.do?action='+ value) //frontcontroller
	.then(result => result.json())
	.then(data => {
		let cartItems = data;
		let basketBody = document.querySelector('#basketBody');
		for (let item of cartItems){
			let productList = makeTemplet(item);
			basketBody.insertAdjacentHTML("beforeend", productList);
		}
	})
	.catch(err => console.log(err));
}

//장바구니 상품 단건삭제(엑스btn)
function eachDel(event){
	let value = "eachDel";
	let delbtn = event.target;
	let eachRow = delbtn.closest('.cartProduct');
	let prdNo = eachRow.querySelector('#selectdeProduct').value;
	fetch('cart.do?action='+ value + '&prdNo=' + prdNo)
	.catch(err => console.log(err));
	eachRow.remove();
}


//전체삭제
function delitem(){
	let cartBody = document.querySelector('#basketBody');
	let value = "delAll";
	fetch('cart.do?action='+ value)
	.catch(err => console.log(err));
	cartBody.remove();
}

//장바구니수량변경
//수량변경
//1)+/-버튼수량변겅
function btnChange(event, upDown){
	let changeBtn = event.target;
	let row = changeBtn.closest('.cartProduct');
	let qtyValue = row.querySelector('#productQcy').value; //value(수량) 디폴트 1. 
	let prdNo = eachRow.querySelector('#selectdeProduct').value; //상품코드
	let qty = parseInt(qtyValue); 
	qty = Math.max(1, qty+upDown); //여기까지 클릭시 value는 변경됨. 
	
	let value = "updateQty";
	fetch('cart.do?action='+ value + '&prdNo=' + prdNo +'&qty=' + qty)
	.catch(err => console.log(err));
	
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
				<p class="mb-0 mt-4">${item.prdPrice}</p>
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
						 id="productQcy" value="${item.cartQty}" oninput="keyChange(event)"/> 
					<div class="input-group-btn">
						<button
							class="btn btn-sm btn-plus rounded-circle bg-light border" onclick="btnChange(event, 1)">
							<i class="fa fa-plus"></i>
						</button>
					</div>
				</div>
			</td>
			<td>
				<p class="mb-0 mt-4">${item.prdPrice} 원</p>
			</td>
			<td>
				<button id="delbtn" class="btn btn-md rounded-circle bg-light border mt-4" onclick="eachDel(event)">
					<i class="fa fa-times text-danger"></i>
				</button>
			</td>
		
		</tr>`;
	return tempelet;	
}



