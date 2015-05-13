<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AJAX之与服务器通过JSON通信</title>
<script type="text/javascript">
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

	//AJAX异步对象相关处理
	window.onload = function () {
		document.getElementsByTagName('button')[0].onclick = function () {
			var h2 = document.getElementsByTagName('h2')[0];
			var xmlHttpRequest = createXMLHttpRequest();
			xmlHttpRequest.open('GET', '${pageContext.request.contextPath}/AServlet', true);
			xmlHttpRequest.send(null);
			xmlHttpRequest.onreadystatechange = function () {
				if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
					//处理服务器发送来的JSON数据
					var text = xmlHttpRequest.responseText;
					var user = eval('(' + text + ')');
					var s = user.username + "," + user.password;
					h2.innerHTML = s;
				}
			};
		};
	};
</script>
</head>
<body>
	<h1>AJAX之与服务器通过JSON通信</h1>
	<button>点击这里</button>
	<h2></h2>

</body>
</html>