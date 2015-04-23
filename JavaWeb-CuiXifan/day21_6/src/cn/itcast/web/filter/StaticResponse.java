package cn.itcast.web.filter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class StaticResponse extends HttpServletResponseWrapper  {
	private PrintWriter pw;

	public StaticResponse(HttpServletResponse response, String path) {
		super(response);

		try {
			pw = new PrintWriter(path, "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		return pw;
	}


}
