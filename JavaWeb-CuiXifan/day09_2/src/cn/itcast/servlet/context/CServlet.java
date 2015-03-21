/*
 * 说明：用ServletContext从web.xml中获取公共初始化参数。
 */
package cn.itcast.servlet.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext app = getServletContext();
		String value = app.getInitParameter("theKey");
		System.out.println(value);
	}

}
