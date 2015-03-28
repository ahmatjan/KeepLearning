<%@ page import="java.util.HashMap" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>out 和 set </h1>
<c:out value="a" /><br>
<c:out value="${ a}" /><br>
<c:out value="${ a }" default="xxx" /><br>
<%
	request.setAttribute("b", "<script>alert('hello');</script>");
 %>
<c:out value="${ b }" escapeXml="true"/><br>

<c:set var="c" value="hello" /><br>
<c:set var="d" value="hello" scope="session"/><br>

<h1>remove</h1><br>
<c:remove var="a" /><br>
<c:remove var="b" scope="request" /><br>
<c:out value="${ b }" default="none"/><br>

<h1>url</h1>
<c:url value="/" /><br>
<c:url value="/AServlet" /><br>
<c:url value="/" var="e" scope="page" /><br>
<c:url value="/AServlet" /><br>
<c:url value="/AServlet">
	<c:param name="username" value="abc" />
	<c:param name="password" value="123" />
</c:url><br>

<h1>if</h1>
<c:set var="f" value="hello" />
<c:if test="${ not empty f }">
	<c:out value="${ f }"></c:out>
</c:if>

<h1>choose</h1>
<c:set var="score" value="${ param.score }" />
<c:choose>
	<c:when test="${ score > 100 || score < 0 }">错误的分数${ score }</c:when>
	<c:when test="${ socre >= 90 }">A级</c:when>
	<c:when test="${ score >= 80 }">B级</c:when>
	<c:when test="${ score >= 70 }">C级</c:when>
	<c:when test="${ score >= 60 }">D级</c:when>
	<c:otherwise>E级</c:otherwise>
</c:choose>

<h1>forEach</h1>
<c:set var="sum" value="0" />
<c:forEach var="i" begin="1" end="10">
	<c:set var="sum" value="${ sum + i }" />
</c:forEach>
<c:out value="${ sum }" /><br>

<c:set var="sum" value="0" />
<c:forEach var="i" begin="1" end="10" step="2">
	<c:set var="sum" value="${ sum + i }" />
</c:forEach>
<c:out value="${ sum }" /><br>

<%
	String[] strs = {"a", "b", "c"};
	pageContext.setAttribute("strs", strs);
 %>
 <c:forEach var="i" items="${ strs }">
 	<c:out value="${ i }" />
 </c:forEach>
 <br>

<%-- 遍历map --%>
<%
	HashMap<String, Integer> grades = new HashMap<String, Integer>();
	grades.put("Chinese", 79);
	grades.put("math", 89);
	pageContext.setAttribute("grades", grades);
 %>
 <c:forEach var="i" items="${ grades }">
 	<c:out value="${ i.key } : ${ i.value }"/>
 </c:forEach>
 <br><br>

<%-- varStatus --%>
<c:forEach var="i" begin="1" end="10" varStatus="vs">
	<c:out value="${ vs.index }" />
	<c:out value="${ vs.count }" />
	<c:out value="${ vs.first }" />
	<c:out value="${ vs.last }" /><br>

</c:forEach>

</body>
</html>