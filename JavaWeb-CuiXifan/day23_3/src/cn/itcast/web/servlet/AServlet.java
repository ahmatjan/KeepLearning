package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * AJAX之与服务器通过JSON进行通信。
 */
public class AServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = "{\"username\": \"ZhangSan\", \"password\": \"123\"}";
		response.getWriter().print(user);
	}
}