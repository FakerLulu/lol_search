<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <title>에러 페이지</title>
    <link href="/reservation/css/style.css" rel="stylesheet">
    <link href="/reservation/css/error.css" rel="stylesheet">
</head>

<body>
<div class="header">
            <header class="header_tit">
                <h1 class="logo">
                    <a href="https://m.naver.com/" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                    <a href="./myreservation" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
                </h1>
                <a href="./bookinglogin" class="btn_my"> <span class="viewReservation" title="예약확인">예약확인</span> </a>
            </header>
        </div>
        <div class="err_msg">
            <h1>에러가 발생했습니다</h1>
				<div class="more">
				    <button class="btn" onclick=history.back()><span>뒤로 가기</span></button>
				</div>
        </div>

 <div class="footer">
            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
            <span class="copyright">© NAVER Corp.</span>
        </div>
</body>

</html>
