/**
 * 
 */

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

// 비밀번호 체크 실시간
function checkPasswordRealtime() {
	let pw = document.querySelector('input[name=pw]').value;
	let confirmPw = document.querySelector('input[name=pwConfirm]').value;
	let message = document.getElementById("pwMessage");

	if (!confirmPw) {
		message.textContent = "";
		return;
	}

	if (pw == confirmPw) {
		message.textContent = "비밀번호가 일치합니다.";
		message.style.color = "green";
	} else {
		message.textContent = "비밀번호가 일치하지 않습니다.";
		message.style.color = "red";
	}
}

// submit 체크
function checkRegister(e) {
	e.preventDefault()
	let pw = document.querySelector('input[name=pw]').value;
	let pwCn = document.querySelector('input[name=pwConfirm]').value;
	let phone = document.querySelector('input[name=userPhone]').value;
	let zipCode = document.querySelector('input[name=zipCode]').value;
	let addOne = document.querySelector('input[name=addOne]').value;
	let addTwo = document.querySelector('input[name=addTwo]').value;

	if (pw != pwCn) {
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
	if (phone.length != 13) {
		alert("전화번호가 올바르지 않습니다. '-'까지 입력해주세요.")
		return false;
	}
	if (zipCode == "" || addOne == "" || addTwo == "") {
		alert("주소가 제대로 입력되지 않았습니다.");
		return false;
	}
	alert("육월육일에 오신 걸 환영합니다!");
	e.target.submit();
}


// 아이디 체크 확인
document.querySelector('#check').addEventListener('click', checks);

function checks() {
	let id = document.querySelector('#userId').value;
	console.log(id);
	fetch('userCheck.do?id=' + id)
		.then(data => data.json())
		.then(result => {
			if (result.retCode == 'Success') {
				console.log(result)
				alert("사용할 수 있는 아이디 입니다.");
			} else if (result.retCode == 'Failure') {
				alert("사용할 수 없는 아이디 입니다.");
				document.querySelector('#userId').value = "";
				document.querySelector('#userId').focus();
			}
		})
}