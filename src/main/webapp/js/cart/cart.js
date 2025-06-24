/*
* cart.js
*/
let basketBody = document.querySelector('#basketBody');
let productList = makeTemplet();
console.log(basketBody);
basketBody.insertAdjacentHTML("beforeend", productList);

function makeTemplet(){
		let tempelet = `
		<tr>
			<th scope="row">
				<div class="d-flex align-items-center">
					<input type="checkbox" id="selectdeProduct"
						name="selectdeProduct" /> <img src="img/vegetable-item-3.png"
						class="img-fluid me-5 rounded-circle "
						style="width: 80px; height: 80px;" alt=""/>
				</div>
			</th>
			<td>
				<p class="mb-0 mt-4">Big Banana</p>
			</td>
			<td>
				<p class="mb-0 mt-4">3,000원</p>
			</td>
			<td>
				<div class="input-group quantity mt-4" style="width: 100px;">
					<div class="input-group-btn">
						<button
							class="btn btn-sm btn-minus rounded-circle bg-light border">
							<i class="fa fa-minus"></i>
						</button>
					</div>
					<input type="text"
						class="form-control form-control-sm text-center border-0"
						value="1"/> 
					<div class="input-group-btn">
						<button
							class="btn btn-sm btn-plus rounded-circle bg-light border">
							<i class="fa fa-plus"></i>
						</button>
					</div>
				</div>
			</td>
			<td>
				<p class="mb-0 mt-4">2.99 $</p>
			</td>
			<td>
				<button class="btn btn-md rounded-circle bg-light border mt-4">
					<i class="fa fa-times text-danger"></i>
				</button>
			</td>
		
		</tr>`;
	return tempelet;	
}