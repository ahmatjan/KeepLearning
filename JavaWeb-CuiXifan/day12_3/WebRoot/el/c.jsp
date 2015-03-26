<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL表达式：十一个内置对象</h1>
<%-- 
        pageScope
        requestScope
        sessionScope
        applicationScope
        param；
        paramValues；
        header；
        headerValues；
        initParam；
        cookie；
        pageContext； 
--%>

<%-- http://localhost:8080/day12_3/el/c.jsp?name=ZhangSan&hobby=code&code=sport --%>
${ param.name }<br>
${ paramValues.hobby[0] }<br>
${ header.Host }<br>
${ initParam.xxx }<br>
${ cookie.JSESSIONID.value }<br>
${ pageContext.session.id }<br>

<%-- 用以下方式来写 a标签 或者 form表单 中的链接 --%>
<a href="${ pageContext.request.contextPath }/el/a.jsp">点击此处</a><br>

</body>
</html>