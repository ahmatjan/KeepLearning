<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  	<h1>页面链接</h1>
  	<a href="${ pageContext.request.contextPath }/BookServlet?method=findAll">查询所有</a><br>
  	<a href="${ pageContext.request.contextPath }/BookServlet?method=findByCategory&category=1">查询SE</a><br>
  	<a href="${ pageContext.request.contextPath }/BookServlet?method=findByCategory&category=2">查询EE</a><br>
  	<a href="${ pageContext.request.contextPath }/BookServlet?method=findByCategory&category=3">查询FrameWork</a><br>
  </body>
</html>
