package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 说明：用来测试BaseServlet的根据参数进行方法调用的功能。
 */
public class AServlet extends BaseServlet {

	public void addUser(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("addUser()...");
	}

	public void deleteUser(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("deleteUser()...");
	}

	public void editUser(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("editUser()...");
	}

	public void loadUser(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("loadUser()...");
	}

	public void findAll(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("findAll()...");
	}
}
