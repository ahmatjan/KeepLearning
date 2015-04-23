<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td {
		border: 1px solid;
	}
</style>
</head>
<body>
	<h1>查询结果</h1>
	<table style="width: 60%; border: 1px solid; text-align: center; border-collapse: collapse;">
		<tr>
			<th>书名</th>
			<th>价格</th>
			<th>分类</th>
		</tr>

		<c:forEach items="${ bookList }" var="book">
		<tr>
			<td>${ book.bname }</td>
			<td>${ book.price }</td>
			<c:choose>
				<c:when test="${ book.category == 1 }"><td style="color: red;">Java SE</td></c:when>
				<c:when test="${ book.category == 2 }"><td style="color: green;">Java EE</td></c:when>
				<c:when test="${ book.category == 3 }"><td style="color: blue;">Java FrameWork</td></c:when>
			</c:choose>
		</tr>
		</c:forEach>
	</table>

</body>
</html>