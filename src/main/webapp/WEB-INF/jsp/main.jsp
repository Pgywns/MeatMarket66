<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <style>
   .hero-header {
    background: linear-gradient(rgba(248, 248, 248, 0.5), rgba(248, 248, 248, 0.5)), url(img/6월6일.png);
    background-position: center center;
    background-repeat: no-repeat;
    background-size: cover;
}
   </style>
        <!-- Hero Start -->
        <div class="container-fluid py-5 mb-5 hero-header">
            <div class="container py-5">
                <div class="row g-5 align-items-center">
                    <div class="col-md-12 col-lg-7">
                        <h4 class="mb-3 text-secondary">100% 국내산!</h4>
                        <h1 class="mb-5 display-3 text-primary">초신선 국내산 고기만 사용합니다!</h1>
                    </div>
                    <div class="col-md-12 col-lg-5">
                        <div id="carouselId" class="carousel slide position-relative" data-bs-ride="carousel">
                            <div class="carousel-inner" role="listbox">
                                <div class="carousel-item active rounded">
                                    <img src="img/main_소.png" class="img-fluid w-100 h-100 rounded" alt="First slide">
                                   
                                </div>
                                <div class="carousel-item rounded">
                                    <img src="img/main_돼지.png" class="img-fluid w-100 h-100 rounded" alt="Second slide">
                                   
                                </div>
                                 <div class="carousel-item rounded">
                                    <img src="img/main_닭.png" class="img-fluid w-100 h-100 rounded" alt="Second slide">
	                                </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#carouselId" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#carouselId" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Hero End -->

        <!-- Featurs Section Start -->
        <div class="container-fluid featurs py-5">
            <div class="container py-5">
                <div class="row g-4">
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto">
                                <i class="fas fa-car-side fa-3x text-white"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>무료 배송</h5>
                                <p class="mb-0">3만원 이상 구매시</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto">
                                <i class="fas fa-user-shield fa-3x text-white"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>안전 결제</h5>
                                <p class="mb-0">믿음직한 결제서비스</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto">
                                <i class="fas fa-exchange-alt fa-3x text-white"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>무료 교환</h5>
                                <p class="mb-0">제품 하자 발견시 무료 교환</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto">
                                <i class="fa fa-phone-alt fa-3x text-white"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>상담 창구</h5>
                                <p class="mb-0">AI 상담사가 신속하게</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Featurs Section End -->

        <!-- Vesitable Shop Start-->
        <div class="container-fluid vesitable py-5">
            <div class="container py-5">
                <h1 class="mb-0">💕한끼뚝딱 밀키트💕</h1>
                <div class="owl-carousel vegetable-carousel justify-content-center" id="mil">
                   <!-- 반복 -->
                
                    <!-- 반복 -->
                </div>
            </div>
        </div>
        <!-- Vesitable Shop End -->

        <!-- Bestsaler Product Start -->
        <div class="container-fluid py-5">
            <div class="container py-5">
                <div class="text-center mx-auto mb-5" style="max-width: 700px;">
                    <h1 class="display-4">🔥앗뜨거 인기상품🔥</h1>
                    <p>정육달인들이 추천하는 인기 상품이에요</p>
                </div>
                <div class="row g-4">
                <c:forEach var="hot" items="${Hlist}">
                    <div class="col-lg-6 col-xl-4">
                        <div class="p-4 rounded bg-light">
                            <div class="row align-items-center">
                                <div class="col-6">
                                    <img src="img/productList/${hot.prdSort }/${hot.prdImage}" class="img-fluid rounded-circle w-100" alt="">
                                </div>
                                <div class="col-6">
                                    <a href="#" class="h4">${hot.prdName }</a>
                                    <p></p>
                                    <h4 class="mb-3">${hot.prdPrice }원</h4>
                                    <a href="#" class="btn border border-secondary rounded-pill px-3 text-primary"><i class="fa fa-shopping-bag me-2 text-primary"></i>장바구니</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                   <!-- 반복 6개 -->
                </div>
            </div>
        </div>
        <!-- Bestsaler Product End -->

        <!-- Tastimonial Start -->
        <div class="container-fluid testimonial py-5">
            <div class="container py-5">
                <div class="testimonial-header text-center">
                    <h4 class="text-primary">고객 리뷰</h4>
                    <h1 class="display-5 mb-5 text-dark">😍고객님들의 성원에 감사😍</h1>
                </div>
                <div class="owl-carousel testimonial-carousel">
                    <div class="testimonial-item img-border-radius bg-light rounded p-4">
                        <div class="position-relative">
                            <i class="fa fa-quote-right fa-2x text-secondary position-absolute" style="bottom: 30px; right: 0;"></i>
                            <div class="mb-4 pb-4 border-bottom border-secondary">
                                <p class="mb-0">작업완료</p>
                            </div>
                            <div class="d-flex align-items-center flex-nowrap">
                                <div class="bg-secondary rounded">
                                    <img src="img/존윅.jpg" class="img-fluid rounded" style="width: 100px; height: 100px;" alt="">
                                </div>
                                <div class="ms-4 d-block">
                                    <h4 class="text-dark">작업완료</h4>
                                    <p class="m-0 pb-3">작업완료</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Tastimonial End -->
	<script src=js/realMain.js>></script>