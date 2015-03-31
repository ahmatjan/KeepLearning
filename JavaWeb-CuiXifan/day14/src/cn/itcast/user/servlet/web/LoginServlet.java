package cn.itcast.user.servlet.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.user.domain.User;
import cn.itcast.user.service.UserException;
import cn.itcast.user.service.UserService;

public class LoginServlet extends HttpServlet {
	private UserService userService = new UserService();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		/*
		* 把JSP中的表单数据封装成User对象
		* 调用UserService#login()方法
		*  		> 如果没有抛出异常，则说明登陆成功，把User信息加入session，然后重定向到welcome.jsp
		*  		> 如果抛出了异常，则把异常信息加入request域，然后转发到login.jsp
		*/
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		try {
			User userInfo = userService.login(user);
			request.getSession().setAttribute("user", userInfo);
			response.sendRedirect(request.getContextPath() + "/welcome.jsp");
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", user);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

}
