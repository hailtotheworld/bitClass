<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<title>My Blog</title>
<link rel="stylesheet" href="css/blog.css">
</head>

<body>

	<!-- 전체 레이아웃을 감싸는 블록: 가운데 정렬, 보더, 쉐도우 -->
	<div id="main_wrap">
		<!-- header 시작 -->
		<%@ include file="frame/header.jsp"%>
		<!-- header 종료 -->

		<!-- 네비게이션 시작 -->
		<%@ include file="frame/nav.jsp"%>
		<!-- 네비게이션 종료 -->

		<!-- Contents 영역 시작 -->
		<div id="contents_wrap">

			<!-- 게시물 영역 시작 -->
			<section>
				<article>
					<h3 class="title_font margin_tb_5 ">하나금융, AI 기술 더해 디지털 플랫폼 키운다
					</h3>
					<div class="margin_tb_5 ">2021.11.19 16:45:10</div>
					<img src="images/mini.jpg" class="margin_tb_5">
					<p class="margin_tb_5 lineheight_180per">하나금융그룹이 인공지능(AI) 기술을
						접목한 금융 서비스를 연달아 선보이며 디지털 플랫폼 강화에 박차를 가하고 있다. 19일 금융권에 따르면 하나금융그룹
						관계사 하나금융융합기술원과 하나금융티아이는 각각 AI 기술을 활용한 투자 금융 서비스와 금융 데이터 분석 AI통합
						플랫폼을 선보였다. 하나금융융합기술원의 AI 기술력을 적용한 '하이로보 적립투자 서비스'는 하나은행의 스마트폰뱅킹 앱
						하나원큐 내 디지털 펀드 플랫폼 '펀샵(Fun#, Fund Shop)'에 적용됐다. 로보어드바이저는
						'로봇'(Robot)과 '투자자문 전문가'(Advisor)를 더한 합성어다. AI 기술을 활용한 수익 알고리즘이
						주가지수나 펀드, 경제성장률 등 사용 가능한 모든 금융데이터를 분석해 투자자의 성향에 맞춘 자산 배분과 상품 설계 등의
						서비스를 제공한다.</p>
				</article>

				<article>
					<h3 class="title_font margin_tb_5 ">달의 97% 사라진다…올해 마지막 ‘우주쇼’
						시작</h3>
					<div class="margin_tb_5 ">2021-11-19 17:20:16</div>
					<img src="images/walle.jpg" class="margin_tb_5">
					<p class="margin_tb_5 lineheight_180per">오늘(19일) 저녁 달이 사라진다. 달의
						97%가 지구 그림자에 가려져 지는 ‘우주쇼’가 펼쳐진다. 고도가 낮을 때 달의 가장 많이 가려지는 현상이 나타나 동쪽
						하늘이 트인 곳에서 관측하는 게 좋다. 국립중앙과학관·국립과천과학관 등에 따르면 이날 진행되는 부분월식은 올해 예정된
						마지막 ‘우주쇼’다. 이번 부분월식은 한국천문연구원에서 발표한 올해 주목할 만한 천문현상 중 국내에서 관측 가능한
						마지막 현상이다. 다음 월식은 2022년 11월 8일에 개기월식으로 일어나 이번 기회를 놓치면 1년을 기다려야 한다.</p>
				</article>
			</section>
			<!-- 게시물 영역 종료 -->


			<!-- aside 시작 -->
			<%@ include file="frame/aside.jsp"%>
			<!-- aside 종료 -->


		</div>
		<!-- Contents 영역 종료 -->

		<!-- footer 시작 -->
			<%@ include file="frame/footer.jsp"%>
		<!-- footer 종료 -->

	</div>




</body>

</html>