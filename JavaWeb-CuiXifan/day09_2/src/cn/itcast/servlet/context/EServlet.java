/*
 * 说明：用ServletContext来访问统计量。
 */
package cn.itcast.servlet.context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute("count", 0);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext app = this.getServletContext();
		int count = (Integer)app.getAttribute("count");
		app.setAttribute("count", ++count);

		PrintWriter out = response.getWriter();
		out.print("<h1>" + count + "</h1>");
	}
}
