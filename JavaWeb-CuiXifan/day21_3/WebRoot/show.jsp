<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>按IP统计访问次数</h1>
	<table style="border: 1px solid black; width:70%; text-align: center;">
		<tr>
			<th>IP</th>
			<th>访问次数</th>
		</tr>
		<c:forEach items="${ map }" var="entry">
		<tr>
			<td>${ entry.key }</td>
			<td>${ entry.value }</td>
		</tr>
		</c:forEach>

	</table>
</body>
</html>