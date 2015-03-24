<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h1 {
		text-align: center;
	}
	table {
		border-collapse: collapse;
		align: center;
		margin: 0 auto;
	}
	td {
		border: 1px solid black;
		width: 200px;
	}
</style>
</head>
<body>
<h1>用JSP动态生成网页</h1>
<table>
	<tr>
		<td>姓名</td>
		<td>年龄</td>
	</tr>
<%
		for (int i = 0; i < 10; i++) {
%>
	<tr>
		<td>张三</td>
		<td>29</td>
	</tr>
<%
		}
%>
</table>

</body>
</html>