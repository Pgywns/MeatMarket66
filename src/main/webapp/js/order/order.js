/**
 * order.js
 */
let orderList = document.querySelector('#orderlist');
let orderProList = orderListTemplete();
orderList.insertAdjacentHTML("beforebegin", orderProList);

//주문목록
function orderListTemplete(){
	let orderList = `<tr>
					  <th scope="row">
						<div class="d-flex align-items-center mt-2">
						<img src="img/vegetable-item-2.jpg" class="img-fluid rounded-circle" style="width: 90px; height: 90px;" alt="">
						</div>
					  </th>
						<td class="py-5">Awesome Brocoli</td>
						<td class="py-5">$69.00</td>
					    <td class="py-5">2</td>
						<td class="py-5">$138.00</td>
					</tr>`
     return orderList;
}

//적립금 모달
let pointBtn  = document.querySelector("#popBtn");
let modal = document.querySelector("#popUp");
let popClose = document.querySelector("#closeBtn");

function modalPop(){
	modal.style.display = "block";
}

popClose.addEventListener("click", () => {
	modal.style.display = "none";
});

