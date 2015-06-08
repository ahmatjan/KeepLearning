package cn.itcast.goods.admin.admin.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.admin.admin.domain.Admin;
import cn.itcast.goods.admin.admin.service.AdminService;
import cn.itcast.servlet.BaseServlet;

/**
 * 管理员模块WEB层
 * @author jason
 *
 */
public class AdminServlet extends BaseServlet {
	private AdminService adminService = new AdminService();

	/**
	 * 管理员登陆
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 获取参数
		 * 2. 调用adminService.login()获取admin对象
		 * 3. 如果admin为空，则把错误信息保存到request域，然后转发到login.jsp
		 * 4. 把admin保存到session中
		 * 5. 转发到/adminjsps/admin/index.jsp
		 */
		String adminname = request.getParameter("adminname");
		String adminpwd = request.getParameter("adminpwd");

		Admin admin = adminService.login(adminname, adminpwd);

		if (admin == null) {
			request.setAttribute("msg", "账号/密码错误");
			return "f:/adminjsps/login.jsp";
		}

		request.getSession().setAttribute("sessionAdmin", admin);

		return "f:/adminjsps/admin/index.jsp";
	}

	/**
	 * 退出
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 使session失效
		 * 重定向到/goods/adminjsps/login.jsp
		 */
		request.getSession().invalidate();
		return "r:/adminjsps/login.jsp";
	}
}
