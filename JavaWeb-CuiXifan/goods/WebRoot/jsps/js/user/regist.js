$(function () {
	//判断表单每一项是否存在错误，如存在则显示错误
	$('.spanError').each(function () {
		showError($(this));
	});

	//切换注册按钮图片
	$('#inputImage').hover(
		function () {
			$(this).attr('src', '/goods/images/regist2.jpg');
		}, 
		function () {
			$(this).attr('src', '/goods/images/regist1.jpg');
		}
	);

	//输入框得到焦点隐藏错误信息
	$('.inputText').focus(function () {
		var spanError = $(this).attr('id') + 'Error';
		$('#' + spanError).text('');
		showError($('#' + spanError));
	});

	//失去焦点进行校验
	$('.inputText').blur(function () {
		var id = $(this).attr('id');
		var funcName = 'validate' + id.substring(0, 1).toUpperCase() + id.substring(1);
		eval(funcName + '()');
	});

	//提交时再次进行一遍校验
	$('#formTable').submit(function () {
		var flag = true;

		if (!validateLoginname()) flag = false;
		if (!validateLoginpass()) flag = false;
		if (!validateReloginpass()) flag = false;
		if (!validateEmail()) flag = false;
		if (!validateVerifyCode()) flag = false;

		return flag;
	});

});

//判断当前元素是否存在
function showError(ele) {
	var text = ele.text();
	if (!text)
		ele.css('display', 'none');
	else
		ele.css('display', '');
}

//更换另一张验证码
function changeAnOtherImg() {
	$('#imgVerifyCode').attr('src', '/goods/VerifyCodeServlet?a=' + (new Date()).getTime());
}

//用户名校验
function validateLoginname() {
	var id = 'loginname';
	var text = $('#' + id).val();
	var spanError = $('#' + id + 'Error');

	//非空校验
	if (!text) {
		spanError.text('用户名不能为空');
		showError(spanError);
		return false;
	}

	//长度校验
	if (text.length < 3 || text.length > 20) {
		spanError.text('用户名必须在3～20之间');
		showError(spanError);
		return false;
	}

	//是否已被注册校验
	var flag = true;
	$.ajax({
		"url": "/goods/UserServlet",
		"data": {"method":"ajaxValidateLoginname", "loginname": text},
		"type": "POST",
		"dataType": "json",
		"async": false,
		"cache": false,
		"success": function (result) {
			if (!result) {
				$('#' + id + 'Error').text('用户名已被注册');
				showError($('#' + id + 'Error'));
				flag = false;
			}
		}
	});
	return flag;
}

//密码校验
function validateLoginpass() {
	var id = 'loginpass';
	var text = $('#' + id).val();
	var spanError = $('#' + id + 'Error');

	//非空校验
	if (!text) {
		spanError.text('密码不能为空');
		showError(spanError);
		return false;
	}

	//长度校验
	if (text.length < 3 || text.length > 20) {
		spanError.text('密码必须在3～20之间');
		showError(spanError);
		return false;
	}
	return true;
}

//确认密码校验
function validateReloginpass() {
	var id = 'reloginpass';
	var text = $('#' + id).val();
	var spanError = $('#' + id + 'Error');

	//非空校验
	if (!text) {
		spanError.text('确认密码不能为空');
		showError(spanError);
		return false;
	}

	//长度校验
	if (text.length < 3 || text.length > 20) {
		spanError.text('确认密码必须在3～20之间');
		showError(spanError);
		return false;
	}

	//一致性校验
	if (text != $('#loginpass').val()) {
		spanError.text('两次输入密码不一致');
		showError(spanError);
		return false;
	}
	return true;
}

//Email校验
function validateEmail() {
	var id = 'email';
	var text = $('#' + id).val();
	var spanError = $('#' + id + 'Error');

	//非空校验
	if (!text) {
		spanError.text('邮箱名不能为空');
		showError(spanError);
		return false;
	}

	//格式校验
	if (!/^([\w-.])+@([\w-])+((\.[\w-]{2,3}){1,2})$/.test(text)) {
		spanError.text('邮箱格式不正确');
		showError(spanError);
		return false;
	}

	//是否已被注册校验
	var flag = true;
	$.ajax({
		"url": "/goods/UserServlet",
		"data": {"method":"ajaxValidateEmail", "email": text},
		"type": "POST",
		"dataType": "json",
		"async": false,
		"cache": false,
		"success": function (result) {
			if (!result) {
				$('#' + id + 'Error').text('Email已被注册');
				showError($('#' + id + 'Error'));
				flag = false;
			}
		}
	});
	return flag;
}

//验证码校验
function validateVerifyCode() {
	var id = 'verifyCode';
	var text = $('#' + id).val();
	var spanError = $('#' + id + 'Error');

	//非空校验
	if (!text) {
		spanError.text('验证码不能为空');
		showError(spanError);
		return false;
	}

	//长度校验
	if (text.length != 4) {
		spanError.text('验证码错误');
		showError(spanError);
		return false;
	}

	var flag = true;
	//AJAX校验
	$.ajax({
		"url": "/goods/UserServlet",
		"data": {"method":"ajaxValidateVerifyCode", "verifyCode": text},
		"type": "POST",
		"dataType": "json",
		"async": false,
		"cache": false,
		"success": function (result) {
			if (!result) {
				$('#' + id + 'Error').text('验证码错误');
				showError($('#' + id + 'Error'));
				flag = false;
			}
		}
	});
	return flag;
}