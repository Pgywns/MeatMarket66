/**
 * 
 */
// 주문 조회
async function selectOrders() {
	let data = await fetch('selectOrder.do')
	let result = await data.json()
	if (result.length === 0) {
		document.getElementById("orderTable").innerHTML = "";
		let emptyRow = `
									<tr>
										<td colspan="5" style="text-align: center;">주문 내역이 없습니다.</td>
									</tr>
								`;
		document.getElementById("orderTable").insertAdjacentHTML("beforeend", emptyRow);
		return;
	} else {
		document.getElementById("orderTable").innerHTML = "";
		result.forEach(async order => {
			let template = `
					<tr onclick="toggleDetail(this)">
						<td>${order.odNo}</td>
						<td>${order.addrOne} ${order.addrTwo}</td>
						<td>${(order.amount).toLocaleString()}원</td>
						<td>${order.odName}님</td>
						<td>${order.odDate}</td>
					</tr>
					<tr class="detail-row">
				<td id="orderInfoTd" colspan="5">
							<div class="detail-content">
					`;
			let data = await fetch('selectOrderInfo.do?odNo=' + order.odNo)
			let result = await data.json()

			result.forEach(orderInfo => {
				if (order.odNo == orderInfo.odNo) {
					template += `
				<p>${orderInfo.prdName} ${orderInfo.odQty}개 <button class="btn" onclick="location.href='reviewForm.do?prdNo=${orderInfo.prdNo}&prdName=${orderInfo.prdName}'">리뷰쓰기</button></p>
				`;
				}
			})
			template += `
							</div>
							</td>
					 </tr>`;
			document.getElementById("orderTable").insertAdjacentHTML("beforeend", template);
		})
	}
}

function toggleDetail(row) {
	const detailRow = row.nextElementSibling;
	const content = detailRow.querySelector(".detail-content");
	content.classList.toggle("open");
}

/*리뷰 조회 */
function selectReviews() {
	fetch('selectReveiw.do')
		.then(data => data.json())
		.then(result => {
			console.log(result);

			if (result.length === 0) {
				document.getElementById("reviewTable").innerHTML = "";
				let emptyRow = `
								<tr>
									<td colspan="5" style="text-align: center;">작성된 리뷰가 없습니다.</td>
								</tr>
							`;
				document.getElementById("reviewTable").insertAdjacentHTML("beforeend", emptyRow);
				return;
			} else {
				document.getElementById("reviewTable").innerHTML = "";
				result.forEach(review => {
					let template = `
				<tr>
				<td>${review.prdName}</td>
				<td>${review.rvwNo}</td>
				<td>${review.rvwContent}</td>
				<td>${review.rvwDate}</td>
				</tr>
				`;
					document.getElementById("reviewTable").insertAdjacentHTML("beforeend", template);
				})
			}
		})
}

/* 적립금 조회 */
function selectPoints() {
	fetch('selectPoint.do')
		.then(data => data.json())
		.then(result => {
			document.getElementById("pointTable").innerHTML = "";
			result.forEach(point => {
				const pointValue = point.point;
				let pointText = pointValue > 0 ? `+${pointValue}` : `${pointValue}`;
				let pointColor = pointValue > 0 ? 'green' : 'red';

				const template = `
				          <tr>
				            <td>${point.odDate}</td>
				            <td style="color: ${pointColor}; font-weight: bold;">${pointText + 'P'}</td>
				          </tr>
				        `;

				document.getElementById("pointTable").insertAdjacentHTML("beforeend", template);
			})
		})
}

// 내 질문 조회
function selectBoards() {
	fetch('selectBoard.do')
		.then(data => data.json())
		.then(result => {
			if (result.length === 0) {
				document.getElementById("boardTable").innerHTML = "";
				let emptyRow = `
											<tr>
												<td colspan="5" style="text-align: center;">내 문의가 없습니다.</td>
											</tr>
										`;
				document.getElementById("boardTable").insertAdjacentHTML("beforeend", emptyRow);
				return;
			} else {
				document.getElementById("boardTable").innerHTML = "";
				result.forEach(board => {
					let template = `
					
					<tr onclick="toggleDetail(this)">
					<td>${board.boardNo}</td>
					<td>${board.boardCategory}</td>
					<td>${board.boardTitle}</td>
					<td>${board.boardContent}</td>
					<td>${board.boardDate}</td>
				</tr>
				<tr class="detail-row">
			<td id="orderInfoTd" colspan="5">
						<div class="detail-content">
						`;
						
						if (board.answer != null) {
									template += `
										${board.answer }
									`;			
						} else {
							template += `
								아직 답변이 없습니다.
							`;
						}
					template += `
						</div>
							</td>
					 </tr>
					 `;
					document.getElementById("boardTable").insertAdjacentHTML("beforeend", template);
				})
			}
		})
}

/* 개인정보 관리 */
function selectUser() {
	fetch('selectUser.do')
		.then(data => data.json())
		.then(result => {
			document.getElementById("userTable").innerHTML = "";
			let template = `
							<tr>
							<th>이름</th>
							<td id="userNameCell">${result.userName}</td>
							<td><button class="btn" onclick="openPopUp('userName', '이름')">수정</button></td>
						</tr>
						<tr>
							<th>아이디</th>
							<td id="userIdCell">${result.userId}</td>
							<td></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td id="pwCell">********</td>
							<td><button class="btn" onclick="openPopUp('userPw', '비밀번호')">수정</button></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td id="userPhoneCell">${result.userPhone}</td>
							<td><button class="btn" onclick="openPopUp('userPhone', '전화번호')">수정</button></td>
						</tr>
		`;
			document.getElementById("userTable").insertAdjacentHTML("beforeend", template);
		})
}

/* 배송지 조회 */
function selectAddress() {
	fetch('selectAddress.do')
		.then(data => data.json())
		.then(result => {
			document.getElementById("addressTable").innerHTML = "";
			result.forEach(addr => {
				let template = `
									<tr id="addrListTr-${addr.addrNo}">
									<td>${addr.firstAddr === 'true' ? '✔️' : ''}</td>
									<td>${addr.addrName}</td>
									<td>${addr.zipCode}</td>
									<td>${addr.addrOne} ${addr.addrTwo}</td>
									<td>
										<input id="inputAddr" type="hidden" value=${addr.addrNo}>
										<button class="btn-delete" onclick="deleteAddress('${addr.firstAddr}', ${addr.addrNo})">삭제</button>
										<button class="btn" onclick="changeFisrtAddr(${addr.addrNo}, ${addr.firstAddr})">기본 배송지 설정</button>
									</td>
								</tr>
			`;
				document.getElementById("addressTable").insertAdjacentHTML("beforeend", template);
			})
		})
}

// 개인정보 수정 모달창
let currentField = "";

function openPopUp(field, labelText) {
	currentField = field;
	document.getElementById("modalTitle").innerText = `${labelText} 수정`;
	document.getElementById("modalLabel").innerText = `${labelText}를 입력하세요`;
	document.getElementById("popUp").style.display = "block";

	const inputField = document.getElementById("modalInput");
	const confirmField = document.getElementById("confirmPwInput");
	const msgField = document.getElementById("pwMatchMsg");
	const addressSection = document.getElementById("addressInputs");

	// 배송지 추가인 경우
	if (field === 'address') {
		document.getElementById("modalBody").style.width = "600px";
		document.getElementById("modalBody").style.height = "auto";
		inputField.style.display = "none";
		confirmField.style.display = "none";
		msgField.innerText = "";

		addressSection.style.display = "block";

		document.getElementById("modalTitle").innerText = "배송지 추가";
		document.getElementById("modalLabel").style.display = "none";
	} else {
		inputField.style.display = "block";
		inputField.type = (field === 'userPw') ? "password" : "text";
		confirmField.style.display = (field === 'userPw') ? "block" : "none";
		confirmField.value = "";
		msgField.innerText = "";

		addressSection.style.display = "none";
		document.getElementById("modalLabel").style.display = "block";
	}
}

// 다음 주소 api
function execDaumPostcode() {
	new daum.Postcode(
		{
			oncomplete: function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

				// 각 주소의 노출 규칙에 따라 주소를 조합한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var addr = ''; // 주소 변수

				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					addr = data.jibunAddress;
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('sample6_postcode').value = data.zonecode;
				document.getElementById("sample6_address").value = addr;
				// 커서를 상세주소 필드로 이동한다.
				document.getElementById("sample6_detailAddress")
					.focus();
			}
		}).open();
}

function closePopUp() {
	document.getElementById('popUp').style.display = 'none';
	document.getElementById('modalInput').value = '';
	document.getElementById('confirmPwInput').value = '';
	document.getElementById('pwMatchMsg').innerText = '';
	document.getElementById('modalLabel').style.display = 'block';

	document.getElementById("popUp").style.display = "none";
	document.getElementById("modalBody").classList.remove("large"); // 크기 초기화
}

function confirmEdit() {
	const newValue = document.getElementById("modalInput").value.trim();
	const addrName = document.getElementById("addrName").value;
	const zipCode = document.querySelector('input[name=zipCode]').value;
	const addrOne = document.querySelector('input[name=addrOne]').value;
	const addrTwo = document.querySelector('input[name=addrTwo]').value;

	let result = "";
	if (currentField == 'address') {

		result = "addrName=" + addrName + "&zipCode=" + zipCode + "&addrOne=" + addrOne + "&addrTwo=" + addrTwo;

		fetch('insertAddress.do?' + result)
			.then(data => data.json())
			.then(resultData => {
				if (resultData.retCode == 'Success') {
					alert("배송지가 추가되었습니다.")
					closePopUp();
					location.reload();
				} else if (resultData.retCode == 'Failure') {
					alert("올바른 값을 입력해주세요.");
					return;
				}
			})
	} else if (newValue === "") {
		alert("값을 입력해주세요.");
		return;
	}

	if (currentField == 'userName') {
		result = "userName=" + newValue;
	} else if (currentField == 'userPw') {
		result = "userPw=" + newValue;
	} else if (currentField == 'userPhone') {
		if (newValue.length != 13) {
			alert("전화번호가 올바르지 않습니다. '-'까지 입력해주세요.")
			document.getElementById("modalInput").value = "";
			document.getElementById("modalInput").focus();
			return;
		} else {
			result = "userPhone=" + newValue;
		}
	}

	if (currentField == 'userName' || currentField == 'userPw' || currentField == 'userPhone') {
		fetch('updateUser.do?' + result)
			.then(data => data.json())
			.then(resultData => {
				if (resultData.retCode == 'Success') {
					alert("성공적으로 변경하였습니다.")
					closePopUp();
					location.reload();
				} else if (resultData.retCode == 'Failure') {
					alert("올바른 값을 입력해주세요.");
					return;
				}
			})
	}
}

// 비밀번호 체크 실시간 여부
function checkPwMatch() {
	const pw1 = document.getElementById("modalInput").value;
	const pw2 = document.getElementById("confirmPwInput").value;
	const msg = document.getElementById("pwMatchMsg");

	if (pw1 === "" || pw2 === "") {
		msg.innerText = "";
		return;
	}

	if (pw1 === pw2) {
		msg.innerText = "비밀번호가 일치합니다.";
		msg.style.color = "green";
	} else {
		msg.innerText = "비밀번호가 일치하지 않습니다.";
		msg.style.color = "red";
	}
}

// 배송지 삭제
function deleteAddress(firstAddr, addrNo) {
	if (firstAddr === 'true') {
		alert("기본 배송지는 삭제할 수 없습니다.")
		return;
	}

	fetch('deleteAddress.do?addrNo=' + addrNo)
		.then(data => data.json())
		.then(result => {
			if (result.retCode == 'Success') {
				alert("성공적으로 삭제하였습니다.");
				document.querySelector("#addrListTr-" + addrNo).remove();
				return;
			} else if (result.retCode == 'Failure') {
				alert("삭제하지 못하였습니다. 다시 시도해 주세요.");
				return;
			}
		})
}

// 기본 배송지 설정
async function changeFisrtAddr(addrNo, firstAddr) {
	let data = await fetch('changeFalse.do');
	let result = await data.json();
	if (result.retCode == 'Success') {
		let data = await fetch('changeFirstAddr.do?addrNo=' + addrNo + '&firstAddr=' + firstAddr)
		let result = await data.json();
		if (result.retCode == 'Success') {
			alert("기본 배송지로 설정하였습니다.");
			showSection('info');
			return;
		} else if (result.retCode == 'Failure') {
			alert("기본 배송지로 설정하지 못하였습니다. 다시 시도해 주세요.");
			return;
		}
	} else if (result.retCode == 'Failure') {
		alert("true를 false로 바꾸기 실패")
		return;
	}
}