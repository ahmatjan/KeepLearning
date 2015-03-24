<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>登陆成功2</h1>
<% 
	String username = (String)session.getAttribute("username");
	if (username == null) {
%>
	<span style="color: red;">请不要冒充领导登陆！</span>
<%
	} else {
 %>
	<span style="color: red;">欢迎欢迎，热烈欢迎。欢迎<%= username %>领导莅临指导！</span>
<% 
	}
 %>

</body>
</html>