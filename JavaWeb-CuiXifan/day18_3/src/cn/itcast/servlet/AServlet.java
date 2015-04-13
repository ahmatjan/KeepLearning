package cn.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/*
 * 说明：获取JNDI资源
 */
public class AServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Context cxt = new InitialContext();
			DataSource dataSource = (DataSource)cxt.lookup("java:comp/env/jdbc/dataSource");

			Connection con = dataSource.getConnection();
			System.out.println(con);

			con.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}