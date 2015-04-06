/*
 * 说明：RegistServlet
 */
package cn.itcast.user.servlet.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import cn.itcast.commons.CommonUtils;
import cn.itcast.user.domain.User;
import cn.itcast.user.service.UserException;
import cn.itcast.user.service.UserService;

public class RegistServlet extends HttpServlet {
	private UserService userService = new UserService();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		//把表单数据封装到user对象中
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);

		//errors用来做数据的输入校验
		HashMap<String, String> errors = new HashMap<String, String>();

		
		// 进行数据的输入校验

		//用户名校验
		if (user.getUsername() == null) {
			errors.put("username", "用户名不能为空");
		} else if (user.getUsername().length() > 20 || user.getUsername().length() < 3) {
			errors.put("username", "用户名在3-20位之间");
		}

		//密码校验
		if (user.getPassword() == null) {
			errors.put("password", "密码不能为空");
		} else if (user.getPassword().length() > 20 || user.getPassword().length() < 3) {
			errors.put("password", "密码在3-20位之间");
		}

		/*
		 * 校验验证码：
		 * 
		 *  校验验证码
		 * > 如果错误，把错误信息添加到request域中，然后转发至regist.jsp中
		 * > 如果正确，继续向下执行
		 */
		String verifyCode = request.getParameter("verifyCode");
		String verifyCodeSession = (String) request.getSession().getAttribute("verifyCode");
		if (verifyCode == null || !verifyCode.equalsIgnoreCase(verifyCodeSession) ) {
			request.setAttribute("user", user);
			errors.put("verifyCode", "验证码错误");
		}

		//如果errors不为空，则把errors放入request域，并进行转发
		if (errors != null && errors.size() > 0) {
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}


		/*
		 * 注册：
		 * 
		 * 	1. 封装表单数据到User中
		 * 2. 调用UserService的regist()方法
		 * 		* 如果没有抛出异常，则输出注册成功
		 * 		* 如果抛出异常，则把错误信息存放到request域中，然后转发到regist.jsp中
		 */
		request.setAttribute("user", user);
		try {
			userService.regist(user);
			response.getWriter().print("<h1>注册成功！</h1>");
			response.getWriter().print("<a href='" + request.getContextPath() + "/login.jsp' >"
					+ "点击此处登陆</a>");
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}
	}

}
