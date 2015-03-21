/*
 * 说明：用ServletContext获取资源路径。
 */
package cn.itcast.servlet.context;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//资源路径的默认根目录是WebRoot。

		//获取某文件的绝对路径
		String path = getServletContext().getRealPath("/index.jsp");
		System.out.println(path);

		//获取某文件的绝对路径并获得对应的文件流
		InputStream is = (InputStream) getServletContext().getResourceAsStream("/index.jsp");

		//获得某文件夹下所有文件路径
		System.out.println(getServletContext().getResourcePaths("/WEB-INF"));
	}
}
