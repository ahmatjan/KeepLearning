<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>会员先生，您早上/下午/晚上好！</h1>
  	<a href="${ pageContext.request.contextPath }/visitor.jsp">游客入口</a><br>
  	<a href="${ pageContext.request.contextPath }/member/member.jsp">会员入口</a><br>
  	<a href="${ pageContext.request.contextPath }/admin/admin.jsp">管理员入口</a><br>

</body>
</html>