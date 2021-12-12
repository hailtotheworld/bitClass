<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// id/pw 값이 일치할 때 저장: 로그인 처리
	if(id.equals(pw)) {
		response.addCookie(CookieBox.createCookie("LOGIN", "SUCCESS", -1, "/"));
		// http://localhost:8080/....
		response.addCookie(CookieBox.createCookie("LOGIN", "SUCCESS", -1, "/"));
	}



%>
    
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%= request.getContextPath() %>
	
	<form action="<%= request.getContextPath() %>/cookie/member/login.jsp">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit">
				</td>
			</tr>
		
		</table>
	</form>

</body>
</html>