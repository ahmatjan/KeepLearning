<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JQuery学习1</title>

<style>
	.classTest {
		width: 100px;
		height: 50px;
		background: green;
	}
</style>

<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-1.5.1.js"></script>
<script>
	$(function () {
		/*
		//文档加载完
		alert('文档加载完毕');

		//选择器
		var ele = $('#notMe');		//id选择器
		alert(ele.text());
		alert(ele.html());

		alert($('div').length);		//元素选择器
		alert($('div').html());

		alert('消失');
		$('.myClass').text('消失');	//类选择器

		alert($('[name=username]').length);		//属性选择器

		alert($(':selected').text());			//表单选择器

		
		//操作HTML
		//操作文本
		var ele = $('#notMe');		//id选择器
		alert(ele.text());
		alert(ele.html());


		//操作属性
		$(':input[name=username]').attr('value', "ZhangSan");

		//操作类
		alert('添加类');
		$('#divTest').addClass('classTest');
		alert('删除类');
		$('#divTest').removeClass();

		//操作CSS
		alert('操作CSS');
		$('#divTest').css('width', '100px').css('height', '50px').css('background', 'blue');

		//遍历
		$('option').each(function () {
			alert($(this).text());
		});
		*/

		//表单提交功能
		$('#btnTest').click(function () {
			$('#formTest').submit();
		});

		//事件响应功能
		$('#divEvent').hover(
			function () {
				$(this).css('background', 'green');
			},
			function () {
				$(this).css('background', 'red');
			}
		);

		//bind和unbind方法
		$('#btnBind').bind('click', function () {
			//$('#formTest').submit();
			alert('只能点击一次的按钮');
			$(this).unbind('click');
		});
	});


</script>

</head>

<body>
	<h1>JQuery学习1</h1>
	<div id="notMe"><p>abc</p></div>
	<div id="myDiv" class="myClass">def</div>
	<span class="myClass">ghi</span>

	<br><br>
	<form>
		用户名：<input type="text" name="username"/><br>
		密码：<input type="password" name="password"/><br>
		学历：<select name="education">
			<option value="1">什么是小学</option>
			<option value="2">小学</option>
			<option value="3">大学</option>
		</select><br>
		<input type="submit" value="提交"/><br>
	</form>
	<br>

	<div id="divTest">divTest</div>

	<form id="formTest" action="http://www.baidu.com">
		formTest
	</form>
	<button id="btnTest">btnTest</button>

	<br><br>
	<div id="divEvent" class="classTest">divEvent</div>

	<br><br>
	<button id="btnBind">btnBind</button>
</body>
</html>