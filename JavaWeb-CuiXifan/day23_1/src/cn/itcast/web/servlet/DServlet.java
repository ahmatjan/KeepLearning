package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * AJAX获取服务器XML响应
 */
public class DServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/xml;charset=utf-8");	//非常重要！！Content-Type必须设置为text/xml类型！！
		String xml = 
				"<students>" +
					"<student id='ITCAST_0001'>" +
						"<name>ZhangSan</name>" +
						"<age>23</age>" +
						"<sex>male</sex>" +
					"</student>" +
				"</students>";
		response.getWriter().print(xml);
	}
}
