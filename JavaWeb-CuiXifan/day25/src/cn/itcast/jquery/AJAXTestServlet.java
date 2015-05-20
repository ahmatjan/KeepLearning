package cn.itcast.jquery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 配合jq2.jsp 进行JQuery测试
 */
public class AJAXTestServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		if (username.equals("qdmmy6"))
			response.getWriter().println("{\"name\":\"好人\", \"age\": 23}");
		else
			response.getWriter().println("{\"name\":\"坏人\", \"age\": 89}");

	}
}
