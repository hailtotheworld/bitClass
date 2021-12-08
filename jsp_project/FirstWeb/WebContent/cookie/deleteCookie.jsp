<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();

%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>쿠키 값 삭제</h1>
	<hr>
	<h3>
	<%

	// 쿠키검색 -> 쿠키수정 (같은 이름의 쿠키를 저장하면 됨)
	if(cookies!=null && cookies.length!=0) {
		for (int i=0;i<cookies.length;i++) {
			if(cookies[i].getName().equals("kName")) {
				// 변경하고자 하는 값을 가지는 쿠키 객체를 생성
				Cookie c = new Cookie("kName", "이강인");
				
				// 쿠키의 유효시간을 0으로 설정 -> 쿠키 삭제
				c.setMaxAge(0);
				
				response.addCookie(c);
				break;
			}
		}
	}
	
	
	
	%>
	
	<a href="viewCookie.jsp">쿠키보기</a>
	</h3>

</body>
</html>