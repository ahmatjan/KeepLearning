/*
 * 说明：为登陆系统提供验证码图片。
 */
package cn.itcast.servlet;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cn.itcast.vcode.utils.VerifyCode;

public class VerifyCodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//利用生成验证码图片
		VerifyCode verifyCode = new VerifyCode();
		BufferedImage bi = verifyCode.getImage();

		//把验证码文字放入放入session中
		HttpSession session = request.getSession();
		session.setAttribute("vcode", verifyCode.getText());
		//验证码图片返回给客户端
		VerifyCode.output(bi, response.getOutputStream());
	}

}
