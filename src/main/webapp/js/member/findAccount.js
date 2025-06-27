/**
 * 
 */

// 아이디 찾기
function findIdCheck() {
	let fidName = document.querySelector('input[name=fidName]').value;
	let fidPhone = document.querySelector('input[name=fidPhone]').value;
	let msg = document.querySelector('#Message');

	fetch('findId.do?name=' + fidName + '&phone=' + fidPhone)
		.then(data => data.json())
		.then(result => {
			if (fidPhone.length != 13) {
				alert("전화번호가 올바르지 않습니다. '-'까지 입력해주세요.")
				document.querySelector('input[name=fidPhone]').value = "";
				document.querySelector('input[name=fidPhone]').focus();
				return;
			}
			if (result.retCode == 'Success') {
				msg.innerHTML = '일치하는 아이디는 <span style="color: green;">' + result.userId + '</span> 입니다.';
				msg.style.color = "black";
			} else if (result.retCode == 'Failure') {
				msg.textContent = "일치하는 회원이 없습니다!"
				msg.style.color = "red";
			}
		})
}

// 비밀번호 찾기
function findPasswordCheck() {
	let userId = document.querySelector('input[name=userId]').value;
	let userName = document.querySelector('input[name=userName]').value;
	let userPhone = document.querySelector('input[name=userPhone]').value;
	let msg = document.querySelector('#passwordMessage');
	
	fetch('findPassword.do?id=' + userId + '&name=' + userName + '&phone=' + userPhone)
	.then(data => data.json())
	.then(result => {
		if (userPhone.length != 13) {
			alert("전화번호가 올바르지 않습니다. '-'까지 입력해주세요.")
			document.querySelector('input[name=userPhone]').value = "";
			document.querySelector('input[name=userPhone]').focus();
			return;
		}
		if (result.retCode == 'Success') {
						msg.innerHTML = '일치하는 비밀번호는 <span style="color: green;">' + result.userPassword + '</span> 입니다.';
						msg.style.color = "black";
					} else if (result.retCode == 'Failure') {
						msg.textContent = "일치하는 회원이 없습니다!"
						msg.style.color = "red";
					}
	})
}