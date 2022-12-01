<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

/*
'페이지지시자블럭'에서 이미 설정했으므로 쓰지 않는다.
response.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");

'내장객체' out이 이미 존재해서 만들필요없다.
PrintWriter out = response.getWriter();
*/

String cnt_ = request.getParameter("cnt");

int cnt = 100;
if(cnt_!=null && !cnt_.equals("")) {
	cnt = Integer.parseInt(cnt_);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% for (int i = 0; i < cnt; i++) { %>
		안녕 Servlet!! <br>
	<% } %>
</body>
</html>