/*
 * 说明：练习用Respose设置状态码，发送错误码。
 */
package cn.itcast.servlet.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setStatus(500);
		//response.sendError(404);
		response.sendError(404, "您访问的资源存在，就不给你看！");
	}

}
