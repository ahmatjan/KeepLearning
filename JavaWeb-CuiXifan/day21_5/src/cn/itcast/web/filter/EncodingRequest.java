package cn.itcast.web.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/*
 * HttpServletRequest的装饰者
 */
public class EncodingRequest extends HttpServletRequestWrapper {
	private HttpServletRequest req;

	public EncodingRequest(HttpServletRequest request) {
		super(request);
		req = request;
	}

	@Override
	public String getParameter(String name) {
		try {
			String param = (String) req.getParameter(name);
			param = new String(param.getBytes("ISO-8859-1"), "UTF-8");
			return param;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
}
