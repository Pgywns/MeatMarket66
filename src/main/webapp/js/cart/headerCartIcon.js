/**
 * headerCartIcon
 */
window.addEventListener('DOMContentLoaded', countCartlist);

//페이지 로드시 장바구니 수량 카운트.
function countCartlist(){
	fetch('cartIcon.do')
	.then(resp => resp.text())
	.then(data => {
		let cartCount = data;
		let cartIcon = document.querySelector('#cartIcon');
		cartIcon.textContent = cartCount;
	})
	.catch(err => console.log(err));
}

function cartPage(id) {
	if (id == null || id == '') {
		alert("로그인 후 가능합니다.");
	} else {
		window.location.href = "cartPage.do";
	}
	
}