package cn.itcast.goods.admin.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 管理员登陆过滤器
 * @author jason
 *
 */
public class AdminLoginFilter implements Filter {

    public AdminLoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		HttpSession session = req.getSession();
		if (session.getAttribute("sessionAdmin") == null) {
			request.setAttribute("msg", "您尚未登陆，不能访问该资源！");
			request.getRequestDispatcher("/adminjsps/msg.jsp").forward(req, response);;
			return;
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
