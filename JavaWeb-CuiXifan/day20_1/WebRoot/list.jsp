<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>客户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<h3 align="center">客户列表</h3>
<table border="1" width="70%" align="center">
	<tr>
		<th>客户姓名</th>
		<th>性别</th>
		<th>生日</th>
		<th>手机</th>
		<th>邮箱</th>
		<th>描述</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${ pb.beanList }" var="cstm">
	<tr>
		<td>${ cstm.cname }</td>
		<td>${ cstm.gender }</td>
		<td>${ cstm.birthday }</td>
		<td>${ cstm.cellphone }</td>
		<td>${ cstm.email }</td>
		<td>${ cstm.description }</td>
		<td>
			<a href="<c:url value='/CustomerServlet?cid=${ cstm.cid }&method=preEdit'/>">编辑</a>
			<a href="<c:url value='/CustomerServlet?cid=${ cstm.cid }&method=delete'/>">删除</a>
		</td>
	</tr>
	</c:forEach>
</table>	
	<div style="text-align: center;">
	第${ pb.pc }页/共${ pb.tp }页
	<a href="${ pb.url }&pc=${ pb.pc-1 }">首页</a>

	<c:if test="${ pb.pc-1 > 1 }">
	<a href="${ pb.url }&pc=${ pb.pc-1 }">上一页</a>
	</c:if>

	<%-- 计算begin和end --%>
	<c:choose>
		<c:when test="${ pb.tp < 10 }"> 
			<c:set var="begin" value="1"/>
			<c:set var="end" value="${ pb.tp }"/>
		</c:when>
		<c:when test="${ pb.pc-4 < 1 }"> 
			<c:set var="begin" value="1"/>
			<c:set var="end" value="10"/>
		</c:when>
		<c:when test="${ pb.pc+5 > pb.tp }"> 
			<c:set var="begin" value="${ pb.tp-9 }"/>
			<c:set var="end" value="${ pb.tp }"/>
		</c:when>
		<c:otherwise>
			<c:set var="begin" value="${ pb.pc-4 }"/>
			<c:set var="end" value="${ pb.pc+5 }"/>
		</c:otherwise>
	</c:choose>

	<c:forEach var="i" begin="${ begin }" end="${ end }">
		<c:choose>
			<c:when test="${ i == pb.pc }">
				[${ i }]
			</c:when>
			<c:otherwise>
				<a href="${ pb.url }&pc=${ i }">[${ i }]</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<a href="${ pb.url }&pc=${ pb.pc+1 }">下一页</a>
	<a href="${ pb.url }&pc=${ pb.tp }">尾页</a>
	</div>
  </body>
</html>
