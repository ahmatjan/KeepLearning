/**
 * 说明：学习Servlet 3.0 的异步处理
 */
package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/AServlet", asyncSupported=true)
public class AServlet extends HttpServlet {
	public void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		//1. 获取异步上下文对象
		final AsyncContext ac = request.startAsync(request, response);

		//2. 启动异步线程对象
		ac.start(new Runnable() {
			public void run() {
				try {
					response.getWriter().println("现在开始<br>");
					for (char c = 'A'; c <= 'Z'; c++) {
						Thread.sleep(300);
						response.getWriter().println(c);
						response.flushBuffer();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 告诉tomcat
				ac.complete();
			}
		});

	}
}
