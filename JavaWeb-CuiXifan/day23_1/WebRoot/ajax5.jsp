<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>省市联动</title>
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
 		//获取省份

		//AJAX异步对象
		var xmlHttpRequest = createXMLHttpRequest();
		xmlHttpRequest.open('GET', '${pageContext.request.contextPath}/EServlet', true);
		xmlHttpRequest.send(null);
		xmlHttpRequest.onreadystatechange = function () {
			if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
				//把服务器返回的字符串进行处理后，添加到省下拉菜单中
				var provinces = xmlHttpRequest.responseText;
				var provinceList = provinces.split(',');
				var provinceSelect = document.getElementsByName('province')[0];
				for (var i = 0; i < provinceList.length; i++) {
					var option = document.createElement('option');
					option.innerHTML = provinceList[i];
					option.value = provinceList[i];
					provinceSelect.appendChild(option);
				}
			}
		}; 

		//获取城市
		document.getElementsByName('province')[0].onchange = function () {
			//AJAX异步对象
			var xmlHttpRequest = createXMLHttpRequest();
			xmlHttpRequest.open('POST', '${pageContext.request.contextPath}/EServlet', true);
			xmlHttpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			var body = 'province=' + document.getElementsByName('province')[0].value;
			xmlHttpRequest.send(body);
			xmlHttpRequest.onreadystatechange = function () {
				if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
					var citySelect = document.getElementsByName('city')[0];
					//把旧的数据从下拉框中删除
					var count = citySelect.children.length;
					for (var i = 0; i < count - 1; i++) {
						citySelect.removeChild(citySelect.children[1]);
					}


					//把服务器返回XML的内容添加到城市下拉菜单中
					var doc = xmlHttpRequest.responseXML;
 					var cities = doc.getElementsByTagName('city');
					for (var i = 0; i < cities.length; i++) {
						var option = document.createElement('option');
						option.innerHTML = cities[i].innerHTML;
						option.value = cities[i].innerHTML;
						citySelect.appendChild(option); 
					}
				}
			};
		};
	};
</script>
</head>
<body>
	<h1>省市联动</h1>

	<select name="province">
		<option>===请选择省===</option>
	</select>

	<select name="city">
		<option>===请选择市===</option>
	</select>
</body>
</html>