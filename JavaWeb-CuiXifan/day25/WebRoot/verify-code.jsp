<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>练习验证码的使用</title>
</head>
<body>
<h1>练习验证码的使用</h1>
<form action="${pageContext.request.contextPath}/VerifyCodeServletTest" method="post">
	用户名: <input type="text" name="username"/><br>
	密码: <input type="password" name="password"/><br>
	验证码：<input type="text" name="verifyCode">
	<img alt="" src="${pageContext.request.contextPath}/VerifyCodeServlet"><br>
	<input type="submit" value="提交"/>

</form>

</body>
</html>