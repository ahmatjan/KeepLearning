package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * AJAX POST请求方式
 */
public class BServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		System.out.println("Hello AJAX!(POST)");

		response.getWriter().println("Hello AJAX!(POST)");
	}

}
