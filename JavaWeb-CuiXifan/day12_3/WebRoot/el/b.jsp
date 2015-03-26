<%@page import="java.util.HashMap"%>
<%@page import="cn.itcast.domain.Person" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL表达式：输出容器或Bean</h1>
<%
	int[] arr =  {0, 1, 2, 3};
	pageContext.setAttribute("arr", arr);

	HashMap map = new HashMap<String, String>();
	map.put("key", "value");
	pageContext.setAttribute("map", map);

	Person p = new Person("ZhangSan", 18, "male");
	pageContext.setAttribute("p", p);
 %>

${ pageScope.arr[2] }<br>
${ pageScope.map.key }<br>
${ pageScope.p.name }<br>
</body>
</html>