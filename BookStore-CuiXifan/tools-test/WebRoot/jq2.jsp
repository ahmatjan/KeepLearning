<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JQuery学习2——AJAX</title>
<script src="${pageContext.request.contextPath}/jquery-1.5.1.js"></script>
<script>
	$(function () {
		$('#inputUsername').blur(function () {
			var username = $('#inputUsername').val();
			$.ajax({
				"url": "${pageContext.request.contextPath}/AJAXTestServlet",	//url请求地址
				"data": {"username": username},			//请求参数
				"async": true,							//是否异步
				"cache": false,							//是否缓存
				"type": "POST",							//请求方式
				"dataType": "json",						//返回值类型
				"success": function (result) {			//回调方法
					$('#spanError').text(result.name + ',' + result.age);
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>JQuery学习2——AJAX</h1>

	<form method="POST">
		用户名：<input type="text" name="username" id="inputUsername"/><span id="spanError"></span><br>
		密码：<input type="password" name="password" id="inputPassword"/><br>
		<input type="submit" value="提交">
	</form><br>

</body>
</html>