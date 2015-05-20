package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;


/*
 * 测试BaseServlet
 * 	> 依赖itcast-tools
 */
public class BaseServletTest extends BaseServlet {
	public String regist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("regist()...");
		resp.getWriter().print("regist()...");
		//return "f:/";		//转发到别处
		//return "r:/";		//重定向到别处
		//return "";		//既不转发，也不重定向
		//return null;		//既不转发，也不重定向
		return null;
	}

	public String login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("login()...");
		resp.getWriter().print("login()...");
		return null;
	}
}
