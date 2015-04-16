package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BServlet extends BaseServlet {

	public String func1(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("func1()...");
		return "/index.jsp";
	}

	public String func2(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("func2()...");
		return "r:/index.jsp";
	}

	public String func3(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("func3()...");
		return "d:/index.jsp";
	}
}