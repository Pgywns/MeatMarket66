// 고객센터 목록
let userId = "${userId}";
let boardCategory = "상품";
const svc = {
	// 공통 글 목록 조회
	btnClickList(boardCategory) {
		fetch('boardList.do?boardCategory=' + boardCategory)
			.then(data => data.json())
			.then(result => {
				document.querySelector('#boardCategory').innerHTML = "";
				result.forEach((board) => {
					let template = `<div class="accordion accordion-flush" id="accordionExample">
	            <div class="accordion-item">
	              <h2 class="accordion-header" id="flush-heading">
	                <button class="accordion-button collapsed" type="button"
	                  data-bs-toggle="collapse"
	                  data-bs-target="#flush-collapseOne"
	                  aria-expanded="false"
	                  aria-controls="flush-collapseOne"
	                  style="height: 55px">
	                  [공통] ${board.boardTitle}
	                </button>
	              </h2>
	              <div id="flush-collapseOne" class="accordion-collapse collapse show"
	                aria-labelledby="flush-heading"
	                data-bs-parent="#accordionExample">
	                <div class="accordion-body w-50">
	                  <p>${board.boardContent}</p>
	                </div>
	              </div>
	            </div>
	          `;
					document.querySelector('#boardCategory').insertAdjacentHTML('beforeend', template);
				});
				//클릭된것처럼 화면 한번 열려짐
				document.querySelectorAll('#boardCategory div.accordion-item button').forEach(item => {
					item.click();
				})
			})
			.catch(err => console.log(err));
	},

	// 내 문의 목록 조회
	btnclickMine() {
		fetch('myBoardList.do')
			.then(data => data.json())
			.then(result => {
				document.querySelector('#boardCategory').innerHTML = "";
				result.forEach((board, idx) => {
					let template = ` <div class="accordion-item" id="myboard${idx}">
	                <h2 class="accordion-header" id="my-heading${idx}">
	                  <button class="accordion-button collapsed" type="button"
	                    data-bs-toggle="collapse"
	                    data-bs-target="#my-collapseOne${idx}"
	                    aria-expanded="false"
	                    aria-controls="my-collapseOne${idx}"
	                    style="height: 55px">
	                    [${board.boardCategory}] ${board.boardTitle}
	                  </button>
	                </h2>
	                <div id="my-collapseOne${idx}" class="accordion-collapse collapse"
	                  aria-labelledby="my-heading${idx}"
	                  data-bs-parent="#accordionFlushExample">
	                  <div class="accordion-body w-50">
	                    <p>${board.boardContent}</p>
	                  </div>
	                </div>
	              </div>`;
					document.querySelector('#boardCategory').insertAdjacentHTML('beforeend', template);
					//document.querySelector('button.accordion-button').click();
				});
				//클릭된것처럼 화면 한번 열려짐
				document.querySelectorAll('#boardCategory div.accordion-item button').forEach(item => {
					item.click();
				})
				/*if (!hasMine) {
					document.querySelector('#boardCategory').innerHTML = "<p>내 문의가 없습니다.</p>";
					//location.href = 'login.do';
				}*/
			})
			.catch(err => console.log(err));
	},
	// 글쓰기 페이지 이동
	btnclickinsert() {
		location.href = 'boardForm.do';
	}
};
// 처음 화면에 공통 문의 불러오기
svc.btnClickList(boardCategory);
// 글쓰기 버튼 이벤트
document.querySelector('#insertBtn').addEventListener('click', () => {
	svc.btnclickinsert();
});

// 내 문의 버튼 이벤트
document.querySelector('#userBtn').addEventListener('click', () => {
	if (userId) {
		svc.btnclickMine(userId);
	} else {
		alert("로그인이 필요합니다.");
		svc.btnClickList(boardCategory);
	}
});

