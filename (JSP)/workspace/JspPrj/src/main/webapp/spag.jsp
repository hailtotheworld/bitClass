<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!---------------------------------------------------------------->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
pageContext.getRequest();
pageContext.getSession();
pageContext.getServletContext();
pageContext.setAttribute("pageInsert", "페이지객체에담았다");
pageContext.setAttribute("result", "페이지result");
%>
<body>
	<%= request.getAttribute("result") %>입니다.
	${result} <br>
	${names[1]} <br>
	${notice.title} <br>
	${pageInsert} <br>
	 <br>
	${result} <br> <!-- pageContext가 우선순위가 높아서 pageContext의 값이 나온다. -->
	${requestScope.result} <br>  <!-- 저장소범위를 한정지어줄수있다.  -->
	 <br>
	${param.n}<br>
	${header.Cookie}<br>
	<br>
	${empty param.n?'값이 비어있습니다':param.n}
</body>
</html>