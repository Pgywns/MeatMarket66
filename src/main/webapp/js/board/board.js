 
const svc = {
	//고객센터목록 ->변경
	btnClickList() {
		document.querySelector('#nav-about-tab').addEventListener('click', function(){
			fetch('boardList.do')
				.then(data => data.json())
				.then(result => {
					document.querySelector('#boardCategory').innerHTML = "";
					result.forEach((board) => {
						let template = `<div class="accordion-item" id="acboard">
								<button class="accordion-button collapsed" type="button"
			  							data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
			  							aria-expanded="false" aria-controls="flush-collapseOne"
			  							style="height: 55px">
			  							<h5 class="accordion-header">${board.boardTitle}</h5>
			  							<p style="">[${board.boardCategory}]${board.boardTitle}</p>
			  					</button>
			  					</div>
			  						<div>
			  							<div id="flush-collapseOne" class="accordion-collapse collapse"
			  								data-bs-parent="#accordionFlushExample ">
			  								<div class="accordion-body w-50">
			  									<p>${board.boardContent}</p>
			  								</div>
			  							</div>
									</div>`;
						document.querySelector('#boardCategory').insertAdjacentHTML('beforeend', template);
						console.log(template);
					})

				})
				.catch(err => console.log(err));
		})

	}
}
svc.btnClickList();
