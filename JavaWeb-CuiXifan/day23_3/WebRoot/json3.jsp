<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用自己封装的AJAX工具</title>
<script src="${pageContext.request.contextPath}/ajaxutils.js"></script>
<script>
	window.onload = function () {
		document.getElementsByTagName('button')[0].onclick = function () {
			ajax(
			{
 				"url": "${pageContext.request.contextPath}/AServlet",
				"type": "json",
				"callback": function (data) {
					var text = data.username + ',' + data.password;
					document.getElementsByTagName('h2')[0].innerHTML = data.username + ',' + data.password;
				}
			}
			);
		};
	};
</script>
</head>
<body>
	<h1>使用自己封装的AJAX工具</h1>
	<button>点击这里</button>
	<h2></h2>
</body>
</html>