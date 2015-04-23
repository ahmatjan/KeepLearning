package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.itcast.web.dao.BookDao;

public class BookServlet extends BaseServlet {
	private BookDao bookDao = new BookDao();

	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("bookList", bookDao.findAll());

		return "show.jsp";
	}

	public String findByCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int category = Integer.parseInt(request.getParameter("category"));
		request.setAttribute("bookList", bookDao.findByCategory(category));

		return "show.jsp";
	}
}
