<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>添加cookie</h1>
<%-- JSP九大内置对象 --%>
<%-- request \ response \ session \ application \ pageContext \ config \ out \ page \ exception --%>

 <% 
	Cookie cookie1 = new Cookie("aaa", "AAA");	
	response.addCookie(cookie1);

	Cookie cookie2 = new Cookie("bbb", "BBB");
	response.addCookie(cookie2);
%>
</body>
</html>