<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSON的应用</title>
<script>
	window.onload = function () {
		//示例1
		var user = {
			"username": "Jason",
			"password": "123"
		};
		alert(user.username + "," + user.password);

		//示例2
		var str = "{ \"username\": \"Jason\", \"password\": \"123\" }";
		var user2 = eval('(' + str + ')');
		alert(user2.username + "," + user2.password);
	};
</script>
</head>
<body>
<h1>JSON的示例</h1>
	
</body>
</html>