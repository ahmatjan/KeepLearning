package cn.itcast.servlet.response;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class GServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/test.jpg");
		byte[] bytes = IOUtils.toByteArray(is);
		response.getOutputStream().write(bytes);;
	}

}
