/**
 * order.js
 */
window.addEventListener('DOMContentLoaded', function(){
	orderList();
	displayAdd();
	
})

let addrNo = 0; //주문서제출시 넘겨줄 주소번호 
let usingPoint = 0; //사용할 포인트

//주문버튼 (주문등록+사용적립금)
function submitOrderForm(){
	
	let checkbox = document.querySelector('#Transfer-1');
	if (!checkbox.checked) {
		alert("상기 주문내역을 확인해주세요.");
		return;
	}
	
	let name = document.querySelector('#name').value;
	let phone = document.querySelector('#phone').value;
	
	if (name == '') {
		alert("받으시는 분 성함은 필수 항목입니다!");
		return;
	}
	
	if (phone == '') {
		alert("연락처는 필수 항목입니다!");
		return;
	}
	
	if (phone.length != 13) {
		alert("전화번호가 올바르지 않습니다. '-'까지 입력해주세요.")
		return false;
	}
	
	let totalEl = document.querySelector('#amount');
	let total = totalEl.textContent
	let amount = total.replace(/[^\d]/g, '');
	upDateUsingPoint()
	fetch('SubmitOrderForm.do?name='+ name +'&addr='+ addrNo +'&amount='+amount+'&phone=' + phone)
	.catch(err => console.log(err));
	
	location.href = 'complete.do'; 
}

//사용한 포인트 DB반영
function upDateUsingPoint(){
	fetch('usingPoint.do?usingPoint=' + usingPoint)
		.catch(err => console.log(err));
}

//기본주소불러오기
function displayAdd(){
	fetch('displayAddress.do')
	.then(result => result.json())
	.then(data =>{
		let address = data;
		document.querySelector('#sample6_postcode').value = address[0].zipCode;
		document.querySelector('#sample6_address').value = address[0].addrOne;
		document.querySelector('#addrTwo').value = address[0].addrTwo;
		addrNo = address[0].addrNo;
	})
	.catch(err => console.log(err));
}

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
		//서브금액 출력
		subtotal()	
	})
		.catch(err => console.log(err));
 }
 
 
let myPoint = 0; // 내 적립금 받아서 사용할 금액비교용
//버튼클릭시 현적립금 받아오기.
function myPointCheck(){
	fetch('myPoint.do')
	.then(resp => resp.text())
	.then(data => {
		myPoint = data;
		let myPointEl = document.querySelector('#myPoint');
		myPointEl.textContent = Number(myPoint).toLocaleString() + 'P';
	})
}

//사용하기 버튼클릭시. 
//1)subTotal - 사용할 적립금.
function usePoint(){
	let usePointEl = document.querySelector('#usePoint');
	usingPoint = parseInt(usePointEl.value);
  
	//사용할 적립금 비교
	if (usingPoint > myPoint) {
		alert("보유한 적립금보다 많이 사용할 수 없습니다.");
		usePointEl.value = "";  // 입력 초기화
		return;
	}
	
	if(usingPoint < 1000 || usePointEl.value == '') {
		alert("1,000P부터 사용가능합니다.");
		usePointEl.value = "";  // 입력 초기화
		return;
	}
	
	//사용적립금반영
	let printUsePointEl = document.querySelector('#myPointPreview');
	printUsePointEl.textContent = usingPoint.toLocaleString() + " p";
	
	//subtotal금액가지고 오기
	let subTotalEl = document.querySelector('.subTotal')
	let subtotalPrice = subTotalEl.textContent
	
	//total금액반영
	let totalEl = document.querySelector('#amount');
	let total = (subtotalPrice - usingPoint)
	
	totalEl.textContent = total.toLocaleString()+'원';	
	
	modal.style.display = "none";
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
//첫로드시 토탈금액 반영
	let totalEl = document.querySelector('#amount');
	totalEl.textContent = subtotal.toLocaleString()+'원';
	
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



// 배송지 모달 열기
function openAddressModal() {
document.querySelector('#addressPopUp').style.display = 'block';

	// 주소 목록 불러오기
	fetch('addressPop.do') 
	.then(res => res.json())
	.then(addresses => {
		let list = '';
		addresses.forEach(addr => {
			list += `
			<div class="border p-2 my-2">
				<label>
					<input type="radio" name="selectAddress" value="${addr.addrNo}"
					onchange="selectAddress(${addr.addrNo}, '${addr.zipCode}', '${addr.addrOne}', '${addr.addrTwo}')">
					(${addr.zipCode}) ${addr.addrOne} ${addr.addrTwo}
				</label>
			</div>`;
		}); //주소선택시 폼에 반영.
		document.querySelector('#addressList').innerHTML = list;
	});
}

// 배송지 모달 닫기
document.querySelector('#addressCloseBtn').addEventListener("click", () => {
	document.querySelector('#addressPopUp').style.display = "none";
});

// 주소 선택 시 값 반영
function selectAddress(addrNoParam, zip, addr1, addr2) {
	document.querySelector('#sample6_postcode').value = zip;
	document.querySelector('#sample6_address').value = addr1;
	document.querySelector('#addrTwo').value = addr2;
	document.querySelector('#addressPopUp').style.display = "none";
	addrNo = addrNoParam;
}
