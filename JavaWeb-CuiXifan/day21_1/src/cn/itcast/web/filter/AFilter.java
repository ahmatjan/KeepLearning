package cn.itcast.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 拦截了对AServlet的request行为
 */
public class AFilter implements Filter {

	public void destroy() { 
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("AFilter#before()...");
		chain.doFilter(request, response);
		System.out.println("AFilter#after()...");
	}

	public void init(FilterConfig config) throws ServletException { }

}
