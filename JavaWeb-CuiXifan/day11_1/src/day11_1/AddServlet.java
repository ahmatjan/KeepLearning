/*
 * 说明：学习JSP和Servlet的交互，和form.jsp和result.jsp配合。
 */
package day11_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取加数
		String s1 = request.getParameter("num1");
		String s2 = request.getParameter("num2");
		int num1 = Integer.parseInt(s1);
		int num2 = Integer.parseInt(s2);

		//进行运算
		int result = num1 + num2;

		//把结果添加到域中
		request.setAttribute("result", result);

		//进行转发
		request.getRequestDispatcher("/jsp2/result.jsp").forward(request, response);
	}

}
