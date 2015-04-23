package cn.itcast.web.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AFilter implements Filter {
	private FilterConfig fConfig;

	public void destroy() {
	}

	//按IP进行访问次数的统计，并把统计结果存放到ServletContext中
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		//统计IP
		String ip = request.getRemoteAddr();
		ServletContext application = fConfig.getServletContext();
		Map<String, Integer> map = (Map<String, Integer>) application.getAttribute("map");
		
		if (!map.containsKey(ip)) {
			map.put(ip, 1);
		} else {
			int cnt = map.get(ip);
			map.put(ip, cnt + 1);
		}

		//放行
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}
}
