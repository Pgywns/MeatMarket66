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

