/**
 * realMain.js
 */

newMil();

// 밀키트 목록
function newMil() {
  fetch("mainMil.do")
    .then(res => res.json())
    .then(result => {
      let container = document.querySelector('#mil');

      // 기존에 있던 요소 다 지우기 (필요 시)
      container.innerHTML = '';

      // 1. 카드 생성
      result.forEach(mil => {
        let str = `
          <div class="border border-primary rounded position-relative vesitable-item">
            <div class="vesitable-img">
				<a href="productDetail.do?prdSort=${mil.prdSort}&prdNo=${mil.prdNo}&prdImage=${mil.prdImage}&prdName=${mil.prdName}&prdPrice=${mil.prdPrice}&prdContent=${mil.prdContent}">
              <img src="img/productList/${mil.prdSort}/${mil.prdImage}" class="img-fluid w-100 rounded-top" alt=""></a>
            </div>
            <div class="text-white bg-primary px-3 py-1 rounded position-absolute" style="top: 10px; right: 10px;">밀키트</div>
            <div class="p-4 rounded-bottom">
              <h4 class="text-truncate" style="max-width: 200px;">${mil.prdName}</h4>
              <p class="truncate-line" style="max-height: 50px; overflow: hidden;">${mil.prdContent}</p>
              <div class="d-flex justify-content-between flex-lg-wrap">
                <p class="text-dark fs-5 fw-bold mb-0">${mil.prdPrice}원</p>
                <a onclick="javascript:productCart(${mil.prdNo});" class="btn border border-secondary rounded-pill px-3 text-primary">
                  <i class="fa fa-shopping-bag me-2 text-primary"></i>장바구니
                </a>
              </div>
            </div>
          </div>`;
        container.insertAdjacentHTML('beforeend', str);
      });
		
	  //Jquery CSS Chat GPT 참조.
      // 2. OwlCarousel 강제 재초기화
      const $carousel = $('.vegetable-carousel');

      if ($carousel.hasClass('owl-loaded')) {
        $carousel.trigger('destroy.owl.carousel');
        $carousel.removeClass('owl-loaded owl-hidden');
        $carousel.find('.owl-stage-outer').children().unwrap();
      }

      // 3. 약간 딜레이 후 정확히 다시 초기화
      setTimeout(() => {
        $carousel.owlCarousel({
          loop: true,
          margin: 20,
          nav: true,
          autoplay: true,
         
          responsive: {
            0: { items: 1 },
            576: { items: 2 },
            768: { items: 3 },
            992: { items: 4 }
          }
        });
      }, 100); // 0.1초 후 실행
    });
}


// 장바구니 누르면 등록.
async function  productCart(productNo){
	let cartQty = 1;
	let prdNo = productNo;

	//재고확인
	let checkStock = await fetch('checkStock.do?prdNo=' + prdNo);
	let stock = await checkStock.text();
	
	if (stock == "guest") {
		alert("로그인 후 가능합니다.");
		return;
	} else if (stock == "admin") {
		alert("관리자 권한으로는 할 수 없습니다.");
		return;
	}
	
	let nowStock = parseInt(stock);
	if (cartQty > nowStock ) {
		alert("재고가 부족합니다. 현재 " + nowStock + "개까지 구매가능 합니다.");
		return; // 더 진행하지 않음
    };
	
	let data = await fetch("cart.do");
	let result = await data.json();

	let cartChk = result.some(cart => cart.prdNo == productNo);

	if (cartChk) {
	    alert("장바구니에 이미 있습니다");
	    return;
	} else {
		
	}

	let addCart = await fetch(`cartAdd.do?prdNo=${prdNo}&cartQty=${cartQty}`);
	let cartResult = await addCart.json();

	if (cartResult.retCode == 'Success') {
	    alert("장바구니에 추가하였습니다.");
		countCartlist(); //헤더 장바구니아이콘 수량반영
	}
};
	