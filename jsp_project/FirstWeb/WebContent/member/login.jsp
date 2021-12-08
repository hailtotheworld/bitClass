<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	Date now = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	String nowDate = format.format(now); // 오늘 날짜 문자열 2021-12-08
	
	if(nowDate.endsWith("32")) {
		// 다른 페이지로 이동
		response.sendRedirect("underCheck.jsp");
		//return;
	}
	
	////////////////////////////////////////////////////
	// 로그인 처리
	// 사용자 입력 데이터 id/pw 를 확인/체크
	// 성공 : session에서 사용자 정보를 저장
	// 이번 테스트의 로그인 성공: id와 pw가 같을때 성공으로 한다!!!
	// 실패 : 다시 로그인 페이지로 이동
	
	// 사용자 데이터 받기
	request.setCharacterEncoding("utf-8");
	
	// 스트립트릿 영역: Java 문법 코드 작성
	String uid = request.getParameter("userid");
	// request: 내장객체(변수의 선언이 없고, 객체의 생성도 없다)
	String pw = request.getParameter("pw");
	
	// 이번 테스트의 로그인 성공: id와 pw가 같을때 성공으로 한다!!!
	if(uid.equals(pw)) {
		// 로그인 성공
		// session 객체 속성에 로그인 정보 저장: id만 저장
		session.setAttribute("id", uid);
	
		// mypage.jsp로 이동하자
		response.sendRedirect("mypage.jsp");
		
		return;
		
		
	} else {
		// 로그인 실패: loginForm.html -> login.jsp
		%>
		
		<script>
			alert('로그인 실패! 로그인 페이지로 이동합니다.');
			// location.href='';
			history.go(-1); // 이전으로 돌아간다는거야			
		</script>
		
	<%
		return;
	}
	%>
	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Login Form Data</h1>
	<!-- 주석테스트 -->
	<%-- 주석테스트 --%>

	아이디:
	<%=uid%>
	<br> 비밀번호:
	<%=request.getParameter("pw")%>

	<br>
	<%=new Date()%> <br>
	<%= nowDate %>
	View COUNT : <%= application.getAttribute("cnt") %>

</body>
</html>









