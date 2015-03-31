<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function _change() {
			var ele = document.getElementById("verifyCodeImage");
			ele.src = "${pageContext.request.contextPath}/VerifyCodeServlet?xxx=" + new Date().getTime();
		}
	</script>

  </head>
  
  <body>
	<h1>注册</h1>
 	<span style="color: red; font-weight: 900;">${ msg }</span>
  	<form action="/day14/RegistServlet" method="post">
  		用户名：<input type="text" name="username" value="${ user.username }"/>${ errors.username }<br>
  		密    码：<input type="password" name="password" value="${ user.password }"/>${ errors.password }<br>
  		验证码：<input type="text" name="verifyCode" style="width: 50px;"/>
  		<img alt="" src="${ pageContext.request.contextPath }/VerifyCodeServlet" id="verifyCodeImage">
  		<a href="javascript:_change()">换一张</a>
  		${ errors.verifyCode }
  		<br>
  		<input type="submit" value="提交" />
  	</form>

  </body>
</html>
