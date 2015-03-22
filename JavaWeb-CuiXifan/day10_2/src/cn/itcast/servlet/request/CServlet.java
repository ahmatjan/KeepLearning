/*
 * 说明：通过Request来获取URL的相关方法。
 */
package cn.itcast.servlet.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println(request.getScheme());				//获取请求协议
		out.println(request.getServerName());		//获取服务器名称
		out.println(request.getServerPort());			//获取服务器端口号
		out.println(request.getContextPath());		//获取项目名称
		out.println(request.getServletPath());			//获取Servlet路径
		out.println(request.getQueryString());		//获取参数部分
		out.println(request.getRequestURI());		//获取请求URI
		out.println(request.getRequestURL());		//获取请求URL
	}

}
