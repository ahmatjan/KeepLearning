package cn.itcast.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AFilter implements Filter {

	public void destroy() { }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("AFilter#start()...");
		chain.doFilter(request, response);
		System.out.println("AFilter#end()...");
	}

	public void init(FilterConfig fConfig) throws ServletException { }

}
