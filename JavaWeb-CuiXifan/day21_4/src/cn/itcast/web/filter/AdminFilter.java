package cn.itcast.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AdminFilter implements Filter {

	public void destroy() { }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String username = (String) req.getSession().getAttribute("admin");
		if (username != null) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("msg", "您可能是个什么，但肯定不是管理员，不要瞎溜达！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException { }

}
