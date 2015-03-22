/*
 * 说明：练习包含(include)
 */
package cn.itcast.servlet.include;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.addHeader("Some-Header", "header");		//留头
		response.getWriter().println("The Body");					//也留体
		request.setAttribute("username", "ZhangSan");		//向request域中添加属性

		request.getRequestDispatcher("/DServlet").include(request, response);
	}

}
