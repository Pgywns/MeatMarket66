/**
 * complete.js
 */
window.addEventListener('DOMContentLoaded', function(){
	completInfo();
	completOrderList();
})

function completInfo(){
	fetch('completeInfo.do')
	.then(result => result.json())
	.then(data => {
		document.querySelector('#orderDate').textContent = data.orderDate;
		document.querySelector('#name').textContent = data.reciveName;
		document.querySelector('#addr').textContent = data.address.zipCode + ' ' + data.address.addrOne + ' ' + data.address.addrTwo;
		document.querySelector('#phone').textContent = data.phone;
		document.querySelector('#amount').textContent = data.amount.toLocaleString()+'원';
		document.querySelector('#myPoint').textContent = data.point.toLocaleString()+'P'
	})
	.catch(err => console.log(err));
}

function completOrderList(){
	fetch('completeList.do')
	.then(result => result.json())
	.then(data => {
		console.log(data)
		let orderList = document.querySelector('#lowListlo');
		for (let item of data){
				let productList = makeTempelet(item);
				orderList.insertAdjacentHTML("beforebegin", productList);
				}
	})
	.catch(err => console.log(err));
}




function makeTempelet(item){
	let tempelet =`	<tr>
						<td><img src="img/productList/${item.prdSort}/${item.prdImage}" alt="상품이미지" style="width: 50px;"></td>
						<td>${item.prdName}</td>
						<td>${item.prdPrice}</td>
						<td>${item.odQty}</td>
						<td>${item.prdPrice * item.odQty}</td>
					</tr>`;		
	return tempelet;	
}