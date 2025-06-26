<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
	<link href="css/member/member.css" rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.5/angular.min.js"></script>
<div class="login-page" ng-app="">

	<div class="login-content login-content-signin" ng-hide="showSignIn">
		<div>
			<h2>아이디 찾기</h2>
			<form class="wrapper-box" id="findId" role="form" onsubmit="javascript:findIdCheck();" method="POST">
				<input type="text" name="fidName" class="form-control form-control-email" placeholder="이름을 입력하세요." required> 
				<input type="text" name="fidPhone" class="form-control form-control-password" placeholder="전화번호를 '-'까지 입력하세요." required> 
				<button type="submit" class="btn btn-submit btn-default pull-right">아이디 찾기</button>
			</form>
			<p id="Message" style="font-size: 0.9em; font-weight:600; height: 20px; margin-top: 20px;"></p>
		</div>
	</div>

	<div class="login-content login-content-signup ng-hide"
		ng-show="showSignIn">
		<div>
			<h2>비밀번호 찾기</h2>
			<form class="wrapper-box" role="form" onsubmit="javascript:findPasswordCheck();" method="POST">
				<input type="text" name="userId" class="form-control form-control-email" placeholder="아이디" required>
				<input type="text" name="userName" class="form-control form-control-password" placeholder="이름" required> 
				<input type="text" name="userPhone" class="form-control form-control-password" placeholder="휴대폰번호 '-'까지 입력" required> 
				<button type="submit" class="btn btn-submit btn-default pull-right">비밀번호 찾기</button>
			</form>
			<p id="passwordMessage" style="font-size: 0.9em; font-weight:600; height: 20px; margin-top: 20px;"></p>
		</div>
	</div>

	<div class="login-switcher">
		<div class="login-switcher-signin" ng-show="showSignIn">
			<h3>아이디를 잊어버렸어요</h3>
			<button ng-click="showSignIn=false">아이디 찾기</button>
		</div>
		<div class="login-switcher-signup" ng-hide="showSignIn">
			<h3>비밀번호를 잊어버렸어요</h3>
			<button ng-click="showSignIn=true">비밀번호 찾기</button>
		</div>
	</div>
</div>
<script src="js/member/findAccount.js"></script>