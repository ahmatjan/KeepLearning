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
})

//判断当前元素是否存在
function showError(ele) {
	var text = ele.text();
	if (!text)
		ele.css('display', 'none');
	else
		ele.css('display', '');
}

//更换另一张验证码
function changeAOther() {
	$('#imgVerifyCode').attr('src', '/goods/VerifyCodeServlet?' + (new Date()).getTime());
}