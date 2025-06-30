/**
 * 
 */
fetch("adminBoardList.do")
	.then(data => data.json())
	.then(result => {
		result.forEach(board => {
			if (board.userId != 'admin') {
			let str = `
					<tr class="main-row" onclick="toggleDetail(this)">
						<td>${board.boardNo }</td>
						<td>${board.boardCategory }</td>
						<td>${board.userId }</td>
						<td>${board.boardTitle }</td>
						<td>${board.boardContent }</td>
						<td>${board.boardDate }</td>
					</tr>
					<tr class="detail-row">
						<td colspan="6">
							<div class="detail-content">
							`;
							
							if (board.answer != null) {
								str += `
									<textarea class="textdata" rows="3" cols="100">${board.answer}</textarea>
								`;
							} else {
								str += `
								<textarea class="textdata" rows="3" cols="100"></textarea>
								`;
							}
							
							str +=	`
								<p></p>
								<button onclick="confirmStock(${board.boardNo }, event)">확인</button>
							</div>
						</td>
					</tr>
					`;
			document.querySelector("#productBox").insertAdjacentHTML("beforeend", str);
			}
		})
	})


function toggleDetail(row) {
	const detailRow = row.nextElementSibling;
	const content = detailRow.querySelector(".detail-content");
	content.classList.toggle("open");
}

function confirmStock(boardNo, e) {
	let content = e.target.closest('.detail-content');
	let data = content.querySelector('.textdata');
	let result = data.value;
	
	fetch("insertAnswer.do?answer=" + result + "&boardNo=" + boardNo)
	.then(res => res.json())
	.then(answer => {
		if (answer.retCode == 'Success') {
			alert("답변이 등록되었습니다.");
			location.reload();
		}
	})
}