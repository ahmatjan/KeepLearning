<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: #15B69A;
		margin: 0px;
		color: #ffffff;
	}
	a {
		text-transform:none;
		text-decoration:none;
		color: #ffffff;
		font-weight: 900;
	} 
	a:hover {
		text-decoration:underline;
	}

	#logo {
		float: left;
	}
</style>
  </head>
  
  <body>
    <div id="logo"><a href="${pageContext.request.contextPath}" target="_parent"><img src="<c:url value='/images/logo2.gif'/>" /></a></div>
	<h1 style="margin-left: 450px;">图书购买交流平台</h1>
	<div style="font-size: 10pt; line-height: 10px;">

	<c:choose>
		<c:when test="${empty sessionUser}">
		  <a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">会员登录</a> |&nbsp; 
		  <a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">注册会员</a>
		</c:when>

		<c:otherwise>
		  会员：${sessionUser.loginname}&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href="<c:url value='/CartItemServlet?method=myCart'/>" target="body">我的购物车</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href="<c:url value='/OrderServlet?method=myOrder'/>" target="body">我的订单</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href="<c:url value='/jsps/user/pwd.jsp'/>" target="body">修改密码</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		  <a href="<c:url value='/UserServlet?method=logout'/>" target="_parent">退出</a>	
		</c:otherwise>
	</c:choose>

</div>
  </body>
</html>
