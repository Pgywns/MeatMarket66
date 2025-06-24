<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.5/angular.min.js"></script>
<div class="login-page" ng-app="">

  <div class="login-content login-content-signin" ng-hide="showSignIn">
    <div>
      <h2>로그인</h2>
      <form class="wrapper-box" role="form" ng-submit="login()">
        <input type="email"
          ng-model="email"
          class="form-control form-control-email"
          placeholder="Email address"
          required>
        <input type="password"
          ng-model="password"
          class="form-control form-control-password"
          placeholder="Password"
          required >
        <!-- <div class="checkbox pull-left">
          <label>
            <input type="checkbox"> Remember me.
          </label>
        </div> -->
        <a class="outer-link pull-left" href="#/forgot">비밀번호 찾기</a>
        <button type="submit" class="btn btn-submit btn-default pull-right">로그인</button>
      </form>
    </div>
  </div>

  <div class="login-content login-content-signup ng-hide" ng-show="showSignIn">
    <div>
      <h2>회원가입</h2>
      <form class="wrapper-box" role="form" ng-submit="register()">
        <input type="text"
          ng-model="username"
          class="form-control form-control-username"
          placeholder="Username"
          required >
        <input type="email"
          ng-model="email"
          class="form-control form-control-email"
          placeholder="Email address"
          required >
        <input type="password"
          ng-model="password"
          class="form-control form-control-password"
          placeholder="Password"
          required >
        <!-- <div class="checkbox pull-left">
          <label>
            <input type="checkbox"> Remember me.
          </label>
        </div> -->
        <button type="submit" class="btn btn-submit btn-default pull-right">회원가입</button>
      </form>
    </div>
  </div>

  <div class="login-switcher">
    <div class="login-switcher-signin" ng-show="showSignIn">
      <h3>계정을 가지고 있습니까?</h3>
      <button ng-click="showSignIn=false">로그인 하기</button>
    </div>
    <div class="login-switcher-signup" ng-hide="showSignIn">
      <h3>계정이 없습니까?</h3>
      <button ng-click="showSignIn=true">회원가입 하기</button>
    </div>
  </div>
</div>

