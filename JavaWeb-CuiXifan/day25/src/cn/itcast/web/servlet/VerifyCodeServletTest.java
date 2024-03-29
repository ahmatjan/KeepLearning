package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 测试VerifyCodeServlet
 */
public class VerifyCodeServletTest extends HttpServlet {

	//将客户端送来的验证码和正确的验证码进行比对
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");

		String verifyCode = request.getParameter("verifyCode");
		String vcode = (String) request.getSession().getAttribute("vCode");

		if (verifyCode.equalsIgnoreCase(vcode))
			response.getWriter().print("验证码正确！");
		else
			response.getWriter().print("验证码错误！");
	}
}
