/*
 * 说明：学习Servlet接口。
 */
package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AServlet implements Servlet {

	//生命周期方法：Servlet对象摧毁前被调用
	public void destroy() {
		System.out.println("destroy()...");
	}

	//获得Servlet的配置信息
	public ServletConfig getServletConfig() {
		return null;
	}

	//获得Servlet的信息
	public String getServletInfo() {
		System.out.println("getServletInfo()...");
		return null;
	}

	//生命周期方法：Servlet对象被创建以后立即被调用一次
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()...");
		System.out.println("key1: " + config.getInitParameter("key1"));
		System.out.println("key2: " + config.getInitParameter("key2"));
	}

	//生命周期方法：每次处理请求时被调用
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("service()...");
	}
}
