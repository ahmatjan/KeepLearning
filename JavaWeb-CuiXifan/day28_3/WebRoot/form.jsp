<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/AServlet" method="post" enctype="multipart/form-data">
		用户名：<input type="text" name="username"><br>
		照  片：<input type="file" name="photo"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>