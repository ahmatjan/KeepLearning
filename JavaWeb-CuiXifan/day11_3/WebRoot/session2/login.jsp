<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>登陆</h1>
<%
	//错误信息提示
	String msg = (String)request.getAttribute("msg");
	if (msg!= null) {
		out.print("<span style=\"color: red;\">" + msg + "</span>");
	}

	//获取Session中的username
	String username = "";
	String temp = (String)session.getAttribute("username");
	if (temp != null) {
		username = temp;
	}
%>
<form action="/day11_3/LoginServlet" method="post">
	用户名：<input type="text" name="username" value="<%= username %>"><br>
	密    码：<input type="password" name="password"><br>
	<input type="submit" value="提交">
</form>

</body>
</html>