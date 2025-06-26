<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.5/angular.min.js"></script>
<div class="login-page" ng-app="">

	<div class="login-content login-content-signin" ng-hide="showSignIn">
		<div>
			<h2>로그인</h2>
			<form class="wrapper-box" role="form" ng-submit="login()" action="login.do">
				<input type="text" ng-model="id"
					class="form-control form-control-email" placeholder="아이디를 입력하세요."
					required> <input type="password" ng-model="password"
					class="form-control form-control-password"
					placeholder="비밀번호를 입력하세요." required>
				<a class="outer-link pull-left" href="#">비밀번호 찾기</a>
				<button type="submit" class="btn btn-submit btn-default pull-right">로그인</button>
			</form>
		</div>
	</div>

	<div class="login-content login-content-signup ng-hide"
		ng-show="showSignIn">
		<div>
			<h2>회원가입</h2>
			<form class="wrapper-box" role="form" ng-submit="register()" action="register.do">
				<input type="text" ng-model="uName" class="form-control form-control-username" placeholder="이름" required> 
				<input type="text" ng-model="uId" class="form-control form-control-email" placeholder="아이디" required>
				<input type="password" ng-model="uPw" class="form-control form-control-password" placeholder="비밀번호" required> 
				<input type="password" ng-model="pwConfirm" class="form-control form-control-password" placeholder="비밀번호 확인" required> 
				<input type="text" ng-model="uPhone" class="form-control form-control-password" placeholder="휴대폰번호 '-'까지 입력" required> 
				<input type="text" ng-model="zipCode" class="zip" id="sample6_postcode" placeholder="우편번호" required readonly>
				<input type="button" class="btn" onclick="execDaumPostcode()" value="우편번호 찾기">
				<input type="text" ng-model="addOne" class="form-control form-control-email" id="sample6_address" placeholder="주소" required readonly>
				<input type="text" ng-model="addTwo" class="form-control form-control-email" id="sample6_detailAddress" placeholder="상세주소" required>
				<button type="submit" class="btn btn-submit btn-default pull-right">회원가입</button>
			</form>
		</div>
	</div>

	<div class="login-switcher">
		<div class="login-switcher-signin" ng-show="showSignIn">
			<h3>육월육일에 오신 적이 있나요?</h3>
			<button ng-click="showSignIn=false">로그인 하기</button>
		</div>
		<div class="login-switcher-signup" ng-hide="showSignIn">
			<h3>육월육일이 처음이신가요?</h3>
			<button ng-click="showSignIn=true">회원가입 하기</button>
		</div>
	</div>
</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}
</script>