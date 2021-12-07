<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
	
		// 쿠키 데이터의 저장
		// 쿠키 이름=값
	
		if(cookies!=null && cookies.length>0) {
			for(int i=0;i<cookies.length;i++) {
				Cookie c = cookies[i];
				out.println(c.getName()+"="+c.getValue());
			}
		}
	%>

</body>
</html>