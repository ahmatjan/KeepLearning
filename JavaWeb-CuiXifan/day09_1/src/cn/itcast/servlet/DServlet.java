/*
 * 说明：测试继承GenericServlet类的使用。
 */
package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DServlet extends GenericServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("被回调的init()...");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("service()...");
	}

	@Override
	public void destroy() {
		System.out.println("destroy()...");
	}
}
