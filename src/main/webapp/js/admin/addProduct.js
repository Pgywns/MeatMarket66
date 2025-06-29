/**
 * 
 */
function addProduct(e) {
	e.preventDefault();
	
	let form = e.target;
	let formData = new FormData(form);
	
	fetch('addProduct.do?', {
			method: 'post',
			body: formData
	})
	.then(data => data.json())
	.then(result => {
		if (result.retCode == "Success") {
			alert("등록을 완료하였습니다.");
			e.target.submit();
		}
	})
}