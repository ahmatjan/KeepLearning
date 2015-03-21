/*
 * 说明：
 * 		1. 测试继承HttpServlet的正确用法，Servlet模板的正确用法。
 * 		2. 说明Servlet并发访问时的线程安全问题:
 * 			(1. 不在Servlet中创建成员变量，只用局部变量。
 * 			(2. 可以创建无状态成员变量。
 * 			(3. 可以创建有状态成员变量，但并发时只调用只读的方法。	
 */
package cn.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

public class FServlet extends HttpServlet {
	private User user;

	public void destroy() {
		System.out.println("destroy()...");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()...");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()...");
	}

	public void init() throws ServletException {
		System.out.println("init()...");
	}

}
