<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/jsps/css/comment/comment.css"/>
</head>
<body>

<div id="divComment">
	<br>
	<br>
	<br>
	<br>
	<hr>
	<br>
	<br>
	<br>
	<br>
	<br>

	<c:forEach var="comment" items="${commentList}">
	<div class="divCommentItem">
		<div class="divMember">
			<div class="divPortrait"><img src="${pageContext.request.contextPath}/images/portrait2.png" ></div>
			<br>
			<div class="divName">${comment.user.loginname}</div>
		</div>
		<div class="divContent">${comment.content}</div>
		<div class="divCommenttime">${comment.commenttime}</div>
	</div>
	</c:forEach>



	<hr>
	<br>
	<br>
	<br>
	<br>
	<br>
	<h2>自己对该书的评价：</h2>
	<form action="${pageContext.request.contextPath}/CommentServlet">
		<input type="hidden" name="method" value="add">
		<input type="hidden" name="bid" value="${bid}">
	<div class="divCommentItem">
		<div class="divMember">
			<div class="divPortrait"><img src="${pageContext.request.contextPath}/images/portrait2.png" ></div>
			<br>
			<div class="divName">${user.loginname}</div>
		</div>
		<textarea class="divContent" name="content"></textarea>

		<div id="divButton">
			<input id="btnSubmit" type="submit" value="提交评论">
			<button id="btnEmpty">重新填写</button>
		</div>
		<div id="msg">${msg}</div>
	</div>
	</form>


	<hr>
	<br>
	<br>
	<br>
</div>
</body>
</html>