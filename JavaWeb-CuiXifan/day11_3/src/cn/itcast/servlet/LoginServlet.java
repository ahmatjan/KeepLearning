package cn.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		//获取Session
		HttpSession session = request.getSession();

		//获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String vcodeJsp = request.getParameter("vcode");
		String vcodeSession = (String) session.getAttribute("vcode");

		//比对验证码
		if (!vcodeJsp.equalsIgnoreCase(vcodeSession)) {
			request.setAttribute("msg", "验证码错误！");
			request.getRequestDispatcher("/session2/login.jsp").forward(request, response);
			return;
		}

		//验证账号密码
		if (username != null && username.startsWith("admin")) {
			session.setAttribute("username", username);
			response.sendRedirect("/day11_3/session2/succ1.jsp");
		} else {
			request.setAttribute("msg", "对不起" + username + "，你的 账号/密码 错误");
			request.getRequestDispatcher("/session2/login.jsp").forward(request, response);
		}
	}

}
