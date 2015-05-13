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

/*
 * option有以下属性：
 * 		method		请求方式
 * 		url			请求url
 * 		async		是否异步
 * 		params		请求体
 * 		callback	回调方法
 * 		type		响应数据类型
 */
function ajax(option) {
	//1. 得到xmlHttpRequest
	var xmlHttpRequest = createXMLHttpRequest();

	//2. 打开xmlHttpRequest
	if (option.method == undefined)
		option.method = 'GET';		//默认是GET方法
	if (option.async == undefined)
		option.async = true;		//默认是异步方法
	xmlHttpRequest.open(option.method, option.url, option.async);

	//2.1 设置请求头
	if (option.method == 'POST')
		xmlHttpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

	//3. 发送请求
	xmlHttpRequest.send(option.params);

	//4. 设置回调函数
	xmlHttpRequest.onreadystatechange = function () {
		if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
			var data;
			if (option.type == undefined || option.type == 'text')		//默认请求体是text
				data = xmlHttpRequest.responseText;
			else if (option.type == 'xml')
				data = xmlHttpRequest.responseXML;
			else if (option.type == 'json') {
				data = eval('(' + xmlHttpRequest.responseText + ')');
			}

			option.callback(data);
		}
	};
}