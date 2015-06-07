package cn.itcast.goods.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import cn.itcast.goods.user.domain.User;

/**
 * 登陆过滤器
 * @author jason
 *
 */
public class LoginFilter implements Filter {

   public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * session中获取User对象
		 * 如果不存在，request域中存入错误信息，转发到msg.jsp
		 * 如果存在，放行
		 */
		HttpServletRequest req = (HttpServletRequest)request;
		User sessionUser = (User)req.getSession().getAttribute("sessionUser");
		if (sessionUser == null) {
			request.setAttribute("code", "error");
			request.setAttribute("msg", "您还没有登陆，不能访问本资源");
			request.getRequestDispatcher("/jsps/msg.jsp").forward(request, response);
			return;
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
