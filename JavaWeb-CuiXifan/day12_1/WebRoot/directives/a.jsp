<%-- pageEncoding用来告诉服务器，源文件的编码方式。它和contentType的设置是一致的。 --%>
<%@ page  pageEncoding="UTF-8" %>

<%-- errorPage用来设置发生错误时的跳转页面 --%>
<%@ page errorPage="b.jsp" %>

<%-- 用来进行导包操作 --%>
<%@ page import="java.util.HashMap"%>

<%-- 导入标签库 --%>
<%-- <%@ taglib prefix="fn" uri=""%>  --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP指令：发生服务器错误的JSP页面</h1>

<%
	int n = 10 / 0;
 %>

</body>
</html>