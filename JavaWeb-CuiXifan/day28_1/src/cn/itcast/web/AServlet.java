/**
 * 说明：学习 注解@WebServlet
 */
package cn.itcast.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * <servlet>
 * 	<servlet-name></servlet-name>
 * 	<servlet-class></servlet-class>
 * 	<init-param>
 * 		<param-name>k1</param-name>
 * 		<param-value>v1</param-value>
 * 	<init-param>
 * 	</init-param>
 * 		<param-name>k2</param-name>
 * 		<param-value>v2</param-value>
 * 	</init-param>
 * 	<load-on-startup>1</load-on-startup>
 * </servlet>
 * 
 * <servlet-mapping>
 * 	<servlet-name>AServlet</servlet-name>
 * 	<url-mapping>/AServlet</url-mapping>
 * </servlet-mapping>
 */
@WebServlet(urlPatterns="/AServlet",
	initParams={
		@WebInitParam(name="k1", value="v1"),
		@WebInitParam(name="k2", value="v2")
	},
	loadOnStartup=1
)
public class AServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hello, Servlet 3.0!");
		response.getWriter().println("Hello, Servlet 3.0!!");
	}
}
