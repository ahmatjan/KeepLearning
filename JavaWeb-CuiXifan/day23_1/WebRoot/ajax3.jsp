<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AJAX进行表单校验</title>
<script>
	//创建XMLHttpRequest，处理浏览器兼容性
	function createXMLHttpRequest() {
		try {
			return new XMLHttpRequest();
		} catch (e) {
			try {
				return ActiveXObject('Msxml2.XMLHTTP');
			} catch (e) {
				try {
					return ActiveXObject('Microsolft.XMLHTTP');
				} catch (e) {
					alert('哥们儿，您用的是什么浏览器啊？');
					throw e;
				}
			}
		}
	}

	window.onload = function () {
		document.getElementsByTagName('input')[0].onblur = function () {
			//1. 创建XMLHttpRequest
			var xmlHttpRequest = createXMLHttpRequest();
			//2. 打开XMLHttpRequest
			xmlHttpRequest.open('POST', '${pageContext.request.contextPath}/CServlet', true);
			//2.1 设置请求头
			xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			//3. 发送请求体
			var username = document.getElementsByName('username')[0].value;
			xmlHttpRequest.send('username=' + username);
			//4. 设置回调函数
			xmlHttpRequest.onreadystatechange = function () {
				if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
					var result = xmlHttpRequest.responseText;
					if (result == "1")
						document.getElementsByTagName('span')[0].innerHTML = "该用户已被注册！";
					else
						document.getElementsByTagName('span')[0].innerHTML = "";
				}
			};
		};
	};
</script>
</head>
<body>
	<h1>AJAX进行表单校验</h1>
	<form>
		用户名：<input type="text" name="username"/><span style="color: red;"></span><br>
		密码：<input type="password" name="password"/><br>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>