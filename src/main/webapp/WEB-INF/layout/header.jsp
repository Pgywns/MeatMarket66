<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid fixed-top">
            <div class="container topbar bg-primary d-none d-lg-block">
                <div class="d-flex justify-content-between">
                    <div class="top-info ps-2">
                        <small class="me-3"><i class="fas fa-map-marker-alt me-2 text-secondary"></i> <a href="#" class="text-white">대구광역시 중구 중앙대로 403</a></small>
                        <small class="me-3"><i class="fas fa-envelope me-2 text-secondary"></i><a href="#" class="text-white">0606@6mont6day.com</a></small>
                    </div>
                    <div class="top-link pe-2">
                        <a href="#" class="text-white"><small class="text-white mx-2">오늘도 육즙이 팡팡!</small>/</a>
                        <a href="#" class="text-white"><small class="text-white mx-2">고기 앞에선 누구나 평등하다.</small>/</a>
                        <a href="#" class="text-white"><small class="text-white ms-2">고기의 품격, 배송의 속도 육월육일</small></a>
                    </div>
                </div>
            </div>
            <div class="container px-0">
                <nav class="navbar navbar-light bg-white navbar-expand-xl">
                    <a href="main.do" class="navbar-brand"><h1 class="text-primary display-6">육월육일</h1></a>
                    <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                        <span class="fa fa-bars text-primary"></span>
                    </button>
                    <div class="collapse navbar-collapse bg-white" id="navbarCollapse">
                        <div class="navbar-nav mx-auto">
                            <a href="proudctList.do" class="nav-item nav-link">쇼핑하기</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                                <div class="dropdown-menu m-0 bg-secondary rounded-0">
                                    <a href="cartPage.do" class="dropdown-item">Cart</a>
                                    <a href="addProductForm.do" class="dropdown-item">상품관리</a>
                                </div>
                            </div>
                            <a href="board.do" class="nav-item nav-link">고객센터</a>
                            <a href="logout.do" class="nav-item nav-link">Logout</a>
                        </div>
                        <div class="d-flex m-3 me-0">
                            <a onclick="javascript:cartPage('${userId }');" class="position-relative me-4 my-auto">
                                <i class="fa fa-shopping-bag fa-2x"></i>
                                <span class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1" id="cartIcon" style="top: -5px; left: 15px; height: 20px; min-width: 20px;">0</span>
                            </a>
                            <c:choose>
                            <c:when test="${userId == null }">                            
                            <a href="login.do" class="my-auto">
                                <i class="fas fa-user fa-2x"></i>
                            </a>
                            </c:when>
                            <c:otherwise>
                            <a href="myPage.do" class="my-auto">
                                <i class="fas fa-user fa-2x"></i>
                            </a>
                            </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
 <script type="text/javascript" src="js/cart/headerCartIcon.js"></script>
