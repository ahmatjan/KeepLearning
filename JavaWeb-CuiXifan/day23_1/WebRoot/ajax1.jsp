<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AJAX GET请求方式</title>
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
	window.onload = function () {
		document.getElementsByTagName('button')[0].onclick = function () {
			//AJAX四步
			//1. 创建XMLHttpRequest
			var xmlHttpRequest = createXMLHttpRequest();

			//2. 打开XMLHttpRequest
			//	> 请求方式
			//	> 请求URL
			//	> 指定是否异步
			xmlHttpRequest.open('GET', "${pageContext.request.contextPath}/AServlet", true);

			//3. 发送请求
			xmlHttpRequest.send(null);		//参数必须为null，不然firefox会出错

			//4. 为XMLHttpRequest的onreadystatechange事件添加监听器
			xmlHttpRequest.onreadystatechange = function () {
				if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
					var text = xmlHttpRequest.responseText;
					document.getElementsByTagName('h1')[0].innerHTML = text;
				}
			};
		}
	};
</script>
</head>
<body>
	<h1></h1>
	<button>点击这里</button>
</body>
</html>