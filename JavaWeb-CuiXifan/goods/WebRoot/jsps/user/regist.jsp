<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/jsps/css/user/regist.css">
<script src="${pageContext.request.contextPath}/jquery/jquery-1.5.1.js"></script>
<script src="${pageContext.request.contextPath}/jsps/js/user/regist.js"></script>
</head>
<body>

<div id="divMain">
	<div id="divTitle">
		<span>用户名注册</span>
	</div>
	<div id="divBody">
		<form method="POST" action="${pageContext.request.contextPath}/UserServlet" id="formTable">
			<input type="hidden" name="method" value="regist"/>
		<table id="tableForm">
			<tr>
				<td class="tdName">用户名：</td>
				<td class="tdText"><input class="inputText" type="text" name="loginname" id="loginname" value="${user.loginname}"/></td>
				<td class="tdError"><span class="spanError" id="loginnameError">${errors.loginname}</span></td>
			</tr>
			<tr>
				<td class="tdName">登陆密码：</td>
				<td class="tdText"><input class="inputText" type="password" name="loginpass" id="loginpass" value="${user.loginpass}"/></td>
				<td class="tdError"><span class="spanError" id="loginpassError">${errors.loginpass}</span></td>
			</tr>
			<tr>
				<td class="tdName">确认密码：</td>
				<td class="tdText"><input class="inputText" type="password" name="reloginpass" id="reloginpass" value="${user.reloginpass}"/></td>
				<td class="tdError"><span class="spanError" id="reloginpassError">${errors.reloginpass}</span></td>
			</tr>
			<tr>
				<td class="tdName">Email：</td>
				<td class="tdText"><input class="inputText" type="text" name="email" id="email" value="${user.email}"/></td>
				<td class="tdError"><span class="spanError" id="emailError">${errors.email}</span></td>
			</tr>
			<tr>
				<td class="tdName">图形验证码：</td>
				<td class="tdText"><input class="inputText" type="text" name="verifyCode" id="verifyCode" value="${user.verifyCode}"/></td>
				<td class="tdError"><span class="spanError" id="verifyCodeError">${errors.verifyCode}</span></td>
			</tr>
			<tr>
				<td class="tdName"></td>
				<td class="tdText"><div id="divVerifyCode"><img id="imgVerifyCode" src="${pageContext.request.contextPath}/VerifyCodeServlet"></div></td>
				<td><a href="javascript:changeAnOtherImg()">换一张</a></td>
			</tr>
			<tr>
				<td class="tdName"></td>
				<td class="tdText"><input id="inputImage" type="image" src="${pageContext.request.contextPath}/images/regist1.jpg"/></td>
				<td class="tdError"></td>
			</tr>
		</table>
		</form>
	</div>
</div>

</body>
</html>