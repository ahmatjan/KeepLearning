/*
 * 说明：练习用Response来设置重定向。
 */
package cn.itcast.servlet.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//方式1.
		response.setStatus(302);
		response.setHeader("Location", "/day10_1/CServlet");

		//方式2.
		//response.sendRedirect("/day10_1/CServlet");
	}
}
