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
		<table id="tableForm">
			<tr>
				<td class="tdName">用户名：</td>
				<td class="tdText"><input class="inputText" type="text" name="username"/></td>
				<td class="tdError"><span class="spanError">用户名不能为空</span></td>
			</tr>
			<tr>
				<td class="tdName">登陆密码：</td>
				<td class="tdText"><input class="inputText" type="password" name="username"/></td>
				<td class="tdError"><span class="spanError"></span></td>
			</tr>
			<tr>
				<td class="tdName">确认密码：</td>
				<td class="tdText"><input class="inputText" type="password" name="username"/></td>
				<td class="tdError"><span class="spanError"></span></td>
			</tr>
			<tr>
				<td class="tdName">Email：</td>
				<td class="tdText"><input class="inputText" type="text" name="username"/></td>
				<td class="tdError"><span class="spanError"></span></td>
			</tr>
			<tr>
				<td class="tdName">图形验证码：</td>
				<td class="tdText"><input class="inputText" type="text" name="username"/></td>
				<td class="tdError"><span class="spanError"></span></td>
			</tr>
			<tr>
				<td class="tdName"></td>
				<td class="tdText"><div id="divVerifyCode"><img id="imgVerifyCode" src="${pageContext.request.contextPath}/VerifyCodeServlet"></div></td>
				<td><a href="javascript:changeAOther()">换一张</a></td>
			</tr>
			<tr>
				<td class="tdName"></td>
				<td class="tdText"><input id="inputImage" type="image" src="${pageContext.request.contextPath}/images/regist1.jpg"/></td>
				<td class="tdError"></td>
			</tr>
		</table>
	</div>
</div>

</body>
</html>