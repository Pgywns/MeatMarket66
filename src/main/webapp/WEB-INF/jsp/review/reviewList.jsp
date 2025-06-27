<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <title>상품 리뷰 작성</title>
  <style>
    * {
      box-sizing: border-box;
    }
    body {
      font-family: 'Noto Sans KR', sans-serif;
      background-color: #f5f5f5;
      margin: 0;
      padding: 20px;
    }
    .review-box {
      background: #fff;
      border: 1px solid #e0e0e0;
      border-radius: 8px;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
      padding: 30px;
      max-width: 720px;
      margin: 40px auto;
    }
    .review-box h3 {
      font-size: 24px;
      color: #333;
      margin-bottom: 25px;
      border-left: 4px solid #4CAF50;
      padding-left: 10px;
    }
    .review-box label {
      display: block;
      margin: 15px 0 8px;
      font-weight: 600;
      color: #555;
      font-size: 14px;
    }
    .review-box input[type="text"],
    .review-box textarea {
      width: 100%;
      padding: 12px 15px;
      border: 1px solid #ccc;
      border-radius: 4px;
      font-size: 14px;
      transition: all 0.3s;
    }
    .review-box input[type="text"]:focus,
    .review-box textarea:focus {
      border-color: #4CAF50;
      box-shadow: 0 0 5px rgba(76, 175, 80, 0.3);
      outline: none;
    }
    .review-box textarea {
      height: 120px;
      resize: vertical;
    }
    .review-box .submit-btn {
      background: #4CAF50;
      color: #fff;
      border: none;
      padding: 14px 25px;
      cursor: pointer;
      font-size: 16px;
      border-radius: 4px;
      margin-top: 20px;
      transition: background 0.3s;
      width: 100%;
    }
    .review-box .submit-btn:hover {
      background: #43A047;
    }
    .purchase-info {
      font-size: 13px;
      color: #999;
      margin-top: 15px;
      text-align: right;
    }
  </style>
</head>
<body>

  <div class="review-box">
    <h3>상품 리뷰 작성</h3>

    <form>
      <label for="nickname">닉네임</label>
      <input type="text" id="nickname" name="nickname" placeholder="예) 장*혜" />

      <label for="purchase-count">구매 횟수</label>
      <input type="text" id="purchase-count" name="purchase-count" placeholder="예) 52회 구매" />

      <label for="content">리뷰 내용</label>
      <textarea id="content" name="content" placeholder="예) 맛있네요, 고소해요^^"></textarea>

      <label for="purchase-date">작성일</label>
      <input type="text" id="purchase-date" name="purchase-date" placeholder="예) 2025-06-17" />

      <label for="products">함께 구매하신 상품</label>
      <input type="text" id="products" name="products" placeholder="예) 소고기 x 2 / 초신선 돼지고기 x 2 / 초신선 이유식 x 5" />

      <button type="submit" class="submit-btn">리뷰 등록</button>
    </form>

    <div class="purchase-info">
      ※ 함께 구매하신 상품 정보는 리뷰에 노출됩니다.
    </div>
  </div>

</body>
</html>
