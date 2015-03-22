/*
 * 说明：练习用Response实现 定时刷新/定时跳转。
 */
package cn.itcast.servlet.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().print("Welcome! Page will go to EServlet in 5 seconds!");
		response.setHeader("Refresh", "5; URL=/day10_1/EServlet");
	}

}
