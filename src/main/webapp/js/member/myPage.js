/**
 * 
 */

/*리뷰 조회 */
function selectReviews() {
	fetch('selectReveiw.do')
		.then(data => data.json())
		.then(result => {
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
				            <td style="color: ${pointColor}; font-weight: bold;">${pointText}</td>
				          </tr>
				        `;

				document.getElementById("pointTable").insertAdjacentHTML("beforeend", template);
			})
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
									<tr>
									<td>${addr.addrName}</td>
									<td>${addr.zipCode}</td>
									<td>${addr.addrOne} ${addr.addrTwo}</td>
									<td>
										<input id="inputAddr" type="hidden" value=${addr.addrNo}>
										<button class="btn-delete" onclick="deleteAddress()">삭제</button>
										<button class="btn" onclick="updateAddress()">변경</button>
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

	if (field === 'userPw') {
		inputField.type = "password";
		confirmField.style.display = "block";
		confirmField.value = "";
		msgField.innerText = "";
	} else {
		inputField.type = "text";
		confirmField.style.display = "none";
		msgField.innerText = "";
	}

	document.getElementById("popUp").style.display = "block";
}

function closePopUp() {
	document.getElementById("popUp").style.display = "none";
}

function confirmEdit() {
	const newValue = document.getElementById("modalInput").value.trim();
	let result = "";
	if (newValue === "") {
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
function deleteAddress() {
	let addrNo = document.getElementById("inputAddr").value;
	
	fetch('deleteAddress.do?addrNo=' + addrNo)
	.then(data => data.json())
	.then(result => {
		if (result.retCode == 'Success') {
			alert("성공적으로 삭제하였습니다.");
			location.reload;
			return;
		} else if (result.retCode == 'Failure') {
			alert("삭제하지 못하였습니다. 다시 시도해 주세요.");
			return;
		}
	})
}