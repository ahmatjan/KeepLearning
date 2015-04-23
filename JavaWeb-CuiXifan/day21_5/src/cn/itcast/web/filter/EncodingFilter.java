package cn.itcast.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/*
 * 进行请求编码的转换
 */
public class EncodingFilter implements Filter {
	public void destroy() { }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String method = req.getMethod();

		if (method.equals("GET")) {
			EncodingRequest er = new EncodingRequest(req);
			chain.doFilter(er, response);
		} else if (method.equals("POST")) {
			request.setCharacterEncoding("UTF-8");
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException { }
}
