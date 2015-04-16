package cn.itcast.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

/*
 * 改写该方法
 * 	1. 能够根据method参数进行方法的调用。
 * 	2. 能够根据其他函数返回值进行多种功能。
 */
public abstract class BaseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1. 能够根据method参数进行方法调用，利用反射进行方法的调用。
		 * 	1.1 解析method参数
		 * 	1.2 获取Class，获取获取对应的方法。
		 * 	1.3 调用Method方法
		 */

		String methodName = req.getParameter("method");
		if (methodName == null || methodName.trim().equals(""))
			throw new RuntimeException("您没有指定method参数！！");

		Class clazz = this.getClass();
		Method method = null;
		try {
			method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("您调用的方法" + methodName + "(req, resp)不存在！！");
		}

		String result = null;
		try {
			result = (String) method.invoke(this, req, resp);
		} catch (Exception e) {
			System.out.println("您掉用的方法" + methodName + "(req, resp)，它内部抛出了异常");
			throw new RuntimeException(e);
		}

		/*
		 * 2. 能够根据其他函数返回值进行多种功能。
		 * 	2.1 分离出前缀和后缀
		 * 	2.2 根据前缀进行各种功能。
		 */
		if (result == null || result.trim().equals(""))
			return;
		if (!result.contains(":"))
			req.getRequestDispatcher(result).forward(req, resp);

		String prefix = result.split(":")[0];
		String postfix = result.split(":")[1];
		if (prefix.equals("") || prefix.equalsIgnoreCase("f"))
			req.getRequestDispatcher(postfix).forward(req, resp);
		else if (prefix.equalsIgnoreCase("r"))
			resp.sendRedirect(postfix);
		else
			throw new RuntimeException("你调用的功能当前不支持！");
	}
}
