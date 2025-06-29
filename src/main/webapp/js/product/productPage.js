/**
 * pagination;
 */

// 목록 첫 호출

svc.productList(1);
paginationAll(1);
pageEvent();
paginationSearch(1);

// 전체  상품 페이지네이션
function paginationAll(page) {
	fetch("productPage.do")
		.then(data => data.json())
		.then(result => {
			let totalCnt = result.totalCnt;
			let start, end;
			let prev, next;
			let realEnd = Math.ceil(totalCnt / 9);
			end = Math.ceil(page / 10) * 10;
			start = end - 9;
			end = end > realEnd ? realEnd : end;
			prev = start > 1;
			next = end < realEnd;

			let target = document.querySelector('.pagination');
			target.innerHTML = "";

			let str = "";
			if (prev) {
				str = `<a href="#" class="rounded" data-page="${start - 1}">&laquo;</a>`;
			} else {
				str = `<a href="#" class="rounded disabled">&laquo;</a>`;
			}
			target.insertAdjacentHTML('beforeend', str);

			for (let p = start; p <= end; p++) {
				if (p == page) {
					str = `<a href="#" class="active rounded" data-page="${p}">${p}</a>`;
				} else {
					str = `<a href="#" class="rounded" data-page="${p}">${p}</a>`;
				}
				target.insertAdjacentHTML('beforeend', str);
			}

			if (next) {
				str = `<a href="#" class="rounded" data-page="${end + 1}">&raquo;</a>`;
			} else {
				str = `<a href="#" class="rounded disabled">&raquo;</a>`;
			}
			target.insertAdjacentHTML('beforeend', str);
		});
		
}


// 페이징 처리

function pageEvent(){
	document.querySelector('.pagination').addEventListener('click', function(e) {
		e.preventDefault();
		
		if(e.target.dataset.page){
			let page = parseInt(e.target.dataset.page);
			svc.productList(page);
			
			if(document.querySelector('#search2').value == ""){
			paginationAll(page);
			} else {
				paginationSearch(page);
				svc.searchList(page); 
			}
			
		}
	})
}

function paginationSearch(page) {
	document.querySelector("#search2").addEventListener('input', async function(e) {
	svc.searchList(page);
	let keyword = e.target.value;
	console.log(keyword);
	let data = await fetch("productSearchPage.do?keyword=" + keyword)
	let result = await data.json();
			let totalCnt = result.totalCnt;
			let start, end;
			let prev, next;
			let realEnd = Math.ceil(totalCnt / 9);
			end = Math.ceil(page / 10) * 10;
			start = end - 9;
			end = end > realEnd ? realEnd : end;
			prev = start > 1;
			next = end < realEnd;

			let target = document.querySelector('.pagination');
			target.innerHTML = "";

			let str = "";
			if (prev) {
				str = `<a href="#" class="rounded" data-page="${start - 1}">&laquo;</a>`;
			} else {
				str = `<a href="#" class="rounded disabled">&laquo;</a>`;
			}
			target.insertAdjacentHTML('beforeend', str);

			for (let p = start; p <= end; p++) {
				if (p == page) {
					str = `<a href="#" class="active rounded" data-page="${p}">${p}</a>`;
				} else {
					str = `<a href="#" class="rounded" data-page="${p}">${p}</a>`;
				}
				target.insertAdjacentHTML('beforeend', str);
			}

			if (next) {
				str = `<a href="#" class="rounded" data-page="${end + 1}">&raquo;</a>`;
			} else {
				str = `<a href="#" class="rounded disabled">&raquo;</a>`;
			}
			target.insertAdjacentHTML('beforeend', str);
			})
	
}



