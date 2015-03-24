<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP的基本语法</h1>

<%-- 这是JSP声明 --%>
<%! 
	public int a = 100;
	public void func() {
		System.out.println("Hello, JSP.");
	}
%>

<%-- 这是JSP执行语句 --%>
<%
	out.print("Hello, JSP.<br>");
	func();
%>

<%-- 这是JSP输出语句 --%>
<%= a %>

</body>
</html>