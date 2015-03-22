/*
 * 说明：练习用Referer头来防盗链。	配合 Referer.html
 */
package cn.itcast.servlet.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String referer = request.getHeader("Referer");
		if (referer == null || referer.equals("localhost")) {
			response.sendRedirect("http://www.baidu.com");
		} else {
			response.getWriter().println("hello");
		}
	}

}
