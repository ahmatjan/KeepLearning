/*
 * 说明：练习用request来获取 请求头(Header)，IP、请求方式、User-Agent
 */
package cn.itcast.servlet.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String addr = request.getRemoteAddr();
		String method = request.getMethod();
		String ua = request.getHeader("User-Agent");

		System.out.println(addr);
		System.out.println(method);
		System.out.println(ua);
		System.out.println("");

		//获取所有的请求头信息
		Enumeration e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String headerName = (String)e.nextElement();
			String headerValue = request.getHeader(headerName);
			System.out.println(headerName + ": " + headerValue);
		}
	}
}
