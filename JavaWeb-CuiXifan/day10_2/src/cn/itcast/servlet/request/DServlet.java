/*
 * 说明：获取请求参数。	配合 Parameter.html
 */
package cn.itcast.servlet.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Get()");
		System.out.println("username: " + request.getParameter("username"));
		System.out.println("password: " + request.getParameter("password"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Post()");
		System.out.println("username: " + req.getParameter("username"));
		System.out.println("password: " + req.getParameter("password"));
		System.out.println(Arrays.toString(req.getParameterValues("hobby")));
	}

}
