<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <h1>登陆</h1>
  <body>
  <span style="color: read; font-weight: 900;">${ msg }</span>
  <form action="${ pageContext.request.contextPath }/LoginServlet" method="post">
  	用户名：<input type="text" name="username" value="${ user.username }" /><br>
  	密    码：<input type="text" name="password" value="${ user.password }" /><br>
  	<input type="submit" value="提交" /><br>
  </form>
  </body>
</html>