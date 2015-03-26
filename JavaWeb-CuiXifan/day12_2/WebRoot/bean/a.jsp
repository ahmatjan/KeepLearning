<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>与JavaBean相关的JSP标签</h1>

<%-- 查找bean，如果找不到则创建之 --%>
<jsp:useBean id="p1" class="cn.itcast.domain.Person" scope="page"/>

<%-- 设置bean属性 --%>
<jsp:setProperty property="name" name="p1" value="ZhangSan"/>
<jsp:setProperty property="age" name="p1" value="18"/>
<jsp:setProperty property="gender" name="p1" value="male"/>

<%-- 获取bean属性 --%>
姓名：<jsp:getProperty property="name" name="p1"/><br>
年龄：<jsp:getProperty property="age" name="p1"/><br>
性别：<jsp:getProperty property="gender" name="p1"/><br>

</body>
</html>