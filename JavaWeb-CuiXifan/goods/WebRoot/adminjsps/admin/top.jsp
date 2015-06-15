<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    <base target="body">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {font-size: 10pt;}
	a {color: #aaa;}

	#logo {float: left;}
</style>
  </head>
  
  <body style="background: rgb(78,78,78);color: #fff;">
    <div id="logo"><a href="${pageContext.request.contextPath}/adminjsps/admin" target="_parent"><img src="<c:url value='/images/logo2.gif'/>" /></a></div>
	<h1 style="text-align: center; line-height: 30px;" id="title">图书购买交流平台后台管理</h1>
	<div style="font-size: 10pt; line-height: 10px;">
		管理员：${sessionAdmin.adminname}&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="<c:url value='/admin/AdminCategoryServlet?method=findAll'/>">分类管理</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="<c:url value='/adminjsps/admin/book/main.jsp'/>">图书管理</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="<c:url value='/admin/AdminOrderServlet?method=findAll'/>">订单管理</a>&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
		<a target="_parent" href="<c:url value='/AdminServlet?method=logout'/>">退出</a>
	</div>
  </body>
</html>
