package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		if (username.contains("admin")) {
			request.getSession().setAttribute("admin", username);
		} else if (username.contains("member")) {
			request.getSession().setAttribute("member", username);
		}

		request.getRequestDispatcher("/visitor.jsp").forward(request, response);
	}

}
