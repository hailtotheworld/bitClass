<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* Object strcnt = application.getAttribute("cnt"); */
	// application 객체의 속성 값을 가져온다!
	String strcnt = (String) application.getAttribute("cnt");
	//getAttribute데이터가져온다.

	int cnt = strcnt == null ? 0: Integer.valueOf(strcnt);
	
	// application 객체의 속성 값 저장!
	application.setAttribute("cnt", String.valueOf(++cnt));
	//setAttribute데이터저장한다.
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 방문자 수 <%= cnt %></h1>	

</body>
</html>