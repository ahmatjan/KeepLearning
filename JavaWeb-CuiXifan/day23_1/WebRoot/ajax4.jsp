<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AJAX获取服务器XML响应</title>
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
			//1. 创建XMLHttpRequest
			var xmlHttpRequest = createXMLHttpRequest();
			//2. 打开XMLHttpRequest
			xmlHttpRequest.open('GET', '${pageContext.request.contextPath}/DServlet', true);
			//3. 发送
			xmlHttpRequest.send(null);
			//4. 设置回调函数
			xmlHttpRequest.onreadystatechange = function () {
				if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
					var students = xmlHttpRequest.responseXML;
					var student = students.getElementsByTagName('student')[0];
					console.log(student);
					var text = student.getElementsByTagName('name')[0].innerHTML + ',' 
						+ student.getElementsByTagName('age')[0].innerHTML + ','
						+ student.getElementsByTagName('sex')[0].innerHTML;
					var h2 = document.getElementsByTagName('h2')[0];
					h2.innerHTML = text;
				}
			};
		};
	};
</script>
</head>

<body>
	<h1>AJAX获取服务器XML响应</h1>
	<h2></h2>
	<button>点击这里</button>
</body>
</html>