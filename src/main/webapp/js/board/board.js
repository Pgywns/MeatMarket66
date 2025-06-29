//고객센터 목록
let userId = "";

document.addEventListener("DOMContentLoaded",()=>{
	 userId = document.getElementById("loginUser").value;
	console.log(userId);
})


let boardCategory = "상품";
let idx = 0;
const svc = {
	btnClickList(boardCategory) {
		fetch('boardList.do?boardCategory=' + boardCategory)
			.then(data => data.json())
			.then(result => {
				document.querySelector('#boardCategory').innerHTML = "";
				result.forEach((board,idx) => {
					let template = `<div class="accordion-item" id="acboard${idx}">
				        <h2 class="accordion-header" id="flush-heading${idx}">
				          <button class="accordion-button collapsed" type="button"
				            data-bs-toggle="collapse"
				            data-bs-target="#flush-collapseOne${idx}"
				            aria-expanded="false"
				            aria-controls="flush-collapseOne${idx}"
				            style="height: 55px">
				           	[공통] [${board.boardCategory}] ${board.boardTitle}
				          </button>
				        </h2>
				        <div id="flush-collapseOne${idx}" class="accordion-collapse collapse"
				          aria-labelledby="flush-heading${idx}"
				          data-bs-parent="#accordionFlushExample">
				          <div class="accordion-body w-50">
				            <p> ${board.boardContent}</p>
				          </div>
				        </div>
				      </div>
					`;

					document.querySelector('#boardCategory').insertAdjacentHTML('beforeend', template);
					console.log(template);
				})
			})
			.catch(err => console.log(err));
	},
	btnclickMine(userId){
		fetch('boardList.do')
		.then(data=>data.json())
		.then(result=>{
			result.forEach((board,idx)=>{
				if(board.userId == userId){
					let template = `<div class="accordion-item" id="myboard${idx}">
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
		                  data-bs-parent="#accordionMine">
		                  <div class="accordion-body w-50">
		                    <p>${board.boardContent}</p>
		                    <small>작성자: ${board.userId}</small>
		                  </div>
		                </div>
		              </div>`;
					  document.querySelector('#boardCategory').insertAdjacentHTML('beforeend', template);
					  console.log(template);
				}
			})
		})
	},
	btnclickinsert(){
		location.href = 'boardinsert.do';
	}
	,
}
svc.btnClickList(boardCategory);
svc.btnclickMine(userId);

//버튼이벤트연결
document.querySelector('#insertBtn').addEventListener('click',()=>{
	svc.btnclickinsert();
});



