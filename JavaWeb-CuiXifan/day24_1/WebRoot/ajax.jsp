<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AJAX & JSON实现省市联动</title>
<script src="${pageContext.request.contextPath}/ajaxutils.js"></script>
<script>
	window.onload = function () {
		//省下拉菜单
		var provinceSelect = document.getElementsByName('province')[0];
		//添加省
		ajax(
		{
			"method": "GET",
			"url": "${pageContext.request.contextPath}/ProvinceCityServlet",
			"type": "json",
			"callback": function (provinceList) {
				for (var i = 0; i < provinceList.length; i++) {
					var option = document.createElement('option');
					option.innerHTML = provinceList[i].name;
					option.value = provinceList[i].pid;
					provinceSelect.appendChild(option);
				}
			}
		}
		);

		//市下拉菜单
		provinceSelect.onchange = function () {
			var citySelect = document.getElementsByName('city')[0];
			//删除原有城市
			while (citySelect.children.length > 1) {
				citySelect.removeChild(citySelect.children[1]);
			}
	
			//添加城市
			ajax(
			{
				"method": "POST",
				"params": "pid=" + provinceSelect.value,
				"url": "${pageContext.request.contextPath}/ProvinceCityServlet",
				"type": "json",
				"callback": function (cityList) {
					for (var i = 0; i < cityList.length; i++) {
						var option = document.createElement('option');
						option.innerHTML = cityList[i].name;
						option.value = cityList[i].cid;
						citySelect.appendChild(option);
					}
				}
			}
			);
		};

	};
</script>
</head>
<body>
	<h1>AJAX & JSON实现省市联动</h1>
	<select name="province">
		<option>==请选择省==</option>
	</select>

	<select name="city">
		<option>==请选择市==</option>
	</select>
</body>
</html>