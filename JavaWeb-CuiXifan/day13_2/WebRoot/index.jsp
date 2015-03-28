<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="it" uri="/WEB-INF/tlds/itcast-tag.tld" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
<%-- 	<it:myTag4/> --%>

  	<it:myTag1/><br>
  	<it:myTag2/><br>
  	<it:myTag3>Hello Tag3!</it:myTag3><br>
	<it:myTag5 test="true">${ "Hello Tag5!" }</it:myTag5><br>
	
  </body>
</html>
