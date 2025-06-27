<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<link href="css/member/member.css" rel="stylesheet">
<link src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.5/angular.min.js"></script>
<div class="login-page" ng-app="">
	<div class="login-content login-content-signin" ng-hide="showSignIn">
		<div>
			<h2>로그인</h2>
			<form class="wrapper-box" role="form" action="login.do" method="POST">
				<input type="text" name="userId" class="form-control form-control-email" placeholder="아이디를 입력하세요." required> 
				<input type="password" name="userPw" class="form-control form-control-password" placeholder="비밀번호를 입력하세요." required> 
				<a class="outer-link pull-left" href="findAccount.do">계정을 잃어버리셨나요?</a>
				<button type="submit" class="btn btn-submit btn-default pull-right">로그인</button>
			</form>
		</div>
	</div>
	<div class="login-content login-content-signup ng-hide"
		ng-show="showSignIn">
		<div>
			<h2>회원가입</h2>
			<form class="wrapper-box" role="form" onsubmit="javascript:checkRegister(event);" action="register.do" method="POST">
				<input type="text" name="userName" class="form-control form-control-username" placeholder="이름" required> 
				<input type="text" id="userId" name="userId" class="idCheck" placeholder="아이디" required>
				<button type="button" id="check" name="check" class="btn button-self">아이디 확인</button>
				<input type="password" name="pw" class="form-control form-control-password" placeholder="비밀번호" required> 
				<input type="password" name="pwConfirm" class="form-control form-control-password" placeholder="비밀번호 확인" oninput="javascript:checkPasswordRealtime();" required>
				<p id="pwMessage" style="font-size: 0.9em; height: 20px; margin-top: 5px;"></p>
				<input type="text" name="userPhone" class="form-control form-control-password" placeholder="휴대폰번호 '-'까지 입력" required> 
				<input type="text" name="zipCode" class="zip" id="sample6_postcode" placeholder="우편번호" required readonly> 
				<button type="button" class="button-self" onclick="javascript:execDaumPostcode();">우편번호 찾기</button>
				<input type="text" name="addOne" class="form-control form-control-email" id="sample6_address" placeholder="주소" required readonly> 
				<input type="text" name="addTwo" class="form-control form-control-email" id="sample6_detailAddress" placeholder="상세주소" required>
				<button type="submit" id="registerBtn" class="btn btn-submit btn-default pull-right" disabled>회원가입</button>
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
<script src="js/member/member.js"></script>