/**
 * 
 */

function selectReviews() {
	fetch('selectReveiw.do')
	.then(data => data.json())
	.then(result => {
		result.forEach(review => {
			let template = `
				<tr>
				<td>${review.prdName}</td>
				<td>${review.rvwNo}</td>
				<td>${review.rvwContent}</td>
				<td>${review.rvwDate}</td>
				</tr>
				`;
				
				document.getElementById("reviewTable").insertAdjacentHTML("beforeend", template);
		})
	})
}