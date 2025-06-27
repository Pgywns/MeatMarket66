/**
 * order.js
 */
window.addEventListener('DOMContentLoaded', orderList);

//주문목록출력
function orderList() {
	fetch('cart.do')
		.then(result => result.json())
		.then(data => {
			let orderItem = data;
			let orderList = document.querySelector('#orderlist');
			for(let item of orderItem){
			let orderProList = orderListTemplete(item);
			orderList.insertAdjacentHTML("beforebegin", orderProList);
			}
			subtotal()
		})
		.catch(err => console.log(err));
 }
	
//버튼클릭시 현적립금 받아오기.
function myPoint(){
	fetch('myPoint.do')
	.then(resp => resp.text())
	.then(data => {
		let myPoint = data;
		let myPointEl = document.querySelector('#myPoint');
		myPointEl.textContent = myPoint;
	})
}

//사용하기 버튼클릭시. 
//1)subTotal - 사용할 적립금.
function usePoint(){
	let usingPoint = 0;
	let usePointEl = document.querySelector('#usePoint');
	usingPoint = usePointEl.value;
	console.log(usingPoint);
	
	//이영역을 orderBtn클릭시 반영되도록해야
	fetch('usingPoint.do?usingPoint='+usingPoint)
	.catch(err => console.log(err));
	
	//사용적립금반영
	let printUsePointEl = document.querySelector('#myPointPreview');
	printUsePointEl.textContent = usingPoint + " p";
	
	//subtotal금액가지고 오기
	let subTotalEl = document.querySelector('.subTotal')
	let subtotalPrice = subTotalEl.textContent;
	console.log(subtotalPrice)
	//total금액반영
	let totalEl = document.querySelector('#amount');
	let total = (subtotalPrice - usingPoint)
	
	totalEl.textContent = total.toLocaleString()+'원';
	
}

//기본주소불러오기



//주문버튼
function Order(){
	
	
}




 //subtoal계산
 function subtotal(){
	let subtotal = 0;
	document.querySelectorAll('.eachTotal').forEach(itemTotal => { //selectAll된 상품별총액 하나씩출력 후 더하기
		let eachTotal = itemTotal.textContent;
		subtotal += parseInt(eachTotal);
	})
	let subtotalEl = document.querySelector('.subTotal');
	subtotalEl.textContent = subtotal
 }
 

 
//주문목록템플릿
function orderListTemplete(item) {
	let orderList = `<tr>
					  <th scope="row">
						<div class="d-flex align-items-center mt-2">
						<img src="img/productList/${item.prdSort}/${item.prdImage}" class="img-fluid rounded-circle" style="width: 90px; height: 90px;" alt="">
						</div>
					  </th>
						<td class="py-5">${item.prdName}</td>
						<td class="py-5">${item.prdPrice}</td>
					    <td class="py-5">${item.cartQty}</td>
						<td class="py-5 eachTotal">${item.prdPrice * item.cartQty}</td>
					</tr>`
	return orderList;
}


 
//적립금 모달
let pointBtn = document.querySelector("#popBtn");
let modal = document.querySelector("#popUp");
let popClose = document.querySelector("#closeBtn");

function modalPop() {
	modal.style.display = "block";
}

popClose.addEventListener("click", () => {
	modal.style.display = "none";
});

