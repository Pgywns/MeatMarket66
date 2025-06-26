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
 
 



 //subtoal계산
 function subtotal(){
	let subtotal = 0;
	document.querySelectorAll('.eachTotal').forEach(itemTotal => { //selectAll된 상품별총액 하나씩출력 후 더하기
		let eachTotal = itemTotal.textContent;
		subtotal += parseInt(eachTotal);
	})
	let subtotalEl = document.querySelector('.subTotal');
	subtotalEl.textContent = subtotal.toLocaleString()+'원';
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


