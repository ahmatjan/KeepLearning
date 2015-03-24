<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>URL重写</h1>
<%-- Server会检查Cookie --%>
<%-- 		如果没有Cookie，在链接后面会附加jsessionid参数 --%>
<%-- 		如果有Cookie，在链接后面不会附加jsessionid参数 --%>
<a href="<%= response.encodeUrl("/day11_3/index.jsp") %>">主页</a><br>
<a href="<%= response.encodeUrl("/day11_3/index.jsp") %>">主页</a><br>

<%= response.encodeUrl("/day11_3/index.jsp") %>


</body>
</html>