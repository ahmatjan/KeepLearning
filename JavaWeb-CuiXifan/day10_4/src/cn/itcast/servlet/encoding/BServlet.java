/*
 * 说明：解决发送request以后，服务端乱码问题。	配合Encoding.html 来使用。
 */
package cn.itcast.servlet.encoding;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//get方法时，解决服务端乱码问题
		String username = request.getParameter("username");
		byte[] bytes = username.getBytes("iso-8859-1");
		username = new String(bytes, "utf-8");

		System.out.println(username);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//post方法时，解决服务端乱码问题
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");

		System.out.println(username);
	}

}
