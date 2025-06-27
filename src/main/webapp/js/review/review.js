/**
 * review.js,테스트
 */
let prdNo=1;
function reviewList(){
	document.querySelector('').innerHTML = "";arguments
	fetch('review.do?prdNo='+prdNo)
	.then(data=>data.json())
	.then(result=>{
		document.querySelector('#reviewbody').innerHTML="";
		result.forEach((review)=>{
			let template = `
			`;
			document.querySelector('#').insertAdjacentHTML('beforeend',template);	
		})
	}).catch(err=>console.log(err));
}