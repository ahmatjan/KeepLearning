package cn.itcast.web.filter;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 用于页面静态的过滤器
 */
public class StaticFilter implements Filter {
	private FilterConfig config;

	public void destroy() {
	}

	/*
	 * 查找对应的静态化页面：
	 * 	> 如果能找到，则重定向至该页面
	 * 	> 如果找不到，则生成该静态化页面，并重定向至该页面
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String category = request.getParameter("category");
		String parentPath = config.getServletContext().getRealPath("/htmls");
		String htmlName = category + ".html";
		File html = new File(parentPath, htmlName);

		if (html.exists()) {
			res.sendRedirect(req.getContextPath() + "/htmls/" + htmlName);
		} else {
			chain.doFilter(req, new StaticResponse(res, html.getAbsolutePath()));
			res.sendRedirect(req.getContextPath() + "/htmls/" + htmlName);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		config = fConfig;
	}

}
