/*
 * 说明：测试继承BServlet，模拟继承GenericServlet时的表现。
 */
package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CServlet extends BServlet {
	@Override
	public void init() {
		System.out.println("被回调的init()...");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("service()...");
	}

	@Override
	public void destroy() {
		System.out.println("destroy()...");
	}
}
