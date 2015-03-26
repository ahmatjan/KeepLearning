<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] arr = {"a", "b", "c"};
	ArrayList list = new ArrayList();
	list.add("a");

	pageContext.setAttribute("arr", arr);
	pageContext.setAttribute("list", list);
 %>

${ fn:length(arr) }<br>
${ fn:length(list) }<br>
${ fn:toLowerCase("Hello World") }<br>
${ fn:contains("abc", "a") }<br>
${ fn:indexOf("hello-world", "-") }<br>
${ fn:trim("    ac   ") }<br>

</body>
</html>