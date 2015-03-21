/*
 * 说明：模拟GenericServlet类。
 */
package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BServlet implements Servlet {
	private ServletConfig config;

	//通常没用
	public void destroy() {
		System.out.println("啊～我要挂了");
	}

	//通过init()来给成员变量servletConfig赋值
	public ServletConfig getServletConfig() {
		return config;
	}

	//通常没用
	public String getServletInfo() {
		return null;
	}

	//生命周期方法：生成实例以后立即会被Tomcat调用一次
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		init();
	}

	//回调方法，方法体为空，等待子类覆盖。
	public void init() {
	}

	//生命周期方法：每次处理请求时会被调用。
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("每次处理请求时都会被调用~");
	}

	//拓展方法：从ServletConfig中获得。
	public ServletContext getServletConetext() {
		return config.getServletContext();
	}

	//拓展方法：从ServletConfig中获得。
	public String getServletName() {
		return config.getServletName();
	}

	//拓展方法：从ServletConfig中获得。
	public String getInitParameter(String name) {
		return config.getInitParameter(name);
	}
}
