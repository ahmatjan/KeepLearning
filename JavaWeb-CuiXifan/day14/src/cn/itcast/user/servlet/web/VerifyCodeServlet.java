package cn.itcast.user.servlet.web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.vcode.utils.VerifyCode;

public class VerifyCodeServlet extends HttpServlet {

	/*
	* 	1.	获取随机验证码图片
	* 	2. 把验证码文字保存在session中
	* 	3. 把图片返回到response中
	*/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VerifyCode verifyCode = new VerifyCode();
		BufferedImage image = verifyCode.getImage();
		request.getSession().setAttribute("verifyCode", verifyCode.getText());
		VerifyCode.output(image, response.getOutputStream());
	}

}
