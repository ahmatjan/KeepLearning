<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP九大内置对象之pageContext</h1>
<%-- 1. pageContext首先是一个域对象 --%>
<%
	pageContext.setAttribute("username", "ZhangSan");
	out.print(pageContext.getAttribute("username"));
%>
<%-- 2. pageContext可以获取其他八大内置对象 --%>
<%-- request \ response \ out \ session \ application \ excepiton \ page \ pageContext \ config --%>
<%
	pageContext.getRequest();
	pageContext.getResponse();
	pageContext.getOut();
	pageContext.getException();
	pageContext.getPage();
	pageContext.getServletContext();
	pageContext.getServletConfig();
	pageContext.getSession();

 %>

</body>
</html>
