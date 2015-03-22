/*
 * 说明：解决发送response后，浏览器乱码问题
 */
package cn.itcast.servlet.encoding;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//设置response发送数据时的编码
		response.setCharacterEncoding("utf-8");				
		//设置浏览器读取response中数据时所采用的编码，该语句“一句顶两句”
		response.setHeader("Content-Type", "text/html; charset=utf-8");		
	}

}
