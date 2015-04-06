/*
 * 说明：
 * 		1. 练习PreparedStatement的使用
 * 		2. 练习JdbcUtils的使用
 */
package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Demo3 {

	/*
	 * 当不使用PreparedStatement时，会遭受SQL攻击
	 */
	public static boolean login(String username, String password) throws SQLException {
		//准备四大参数
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/exam";
		String dbUsername = "root";
		String dbPassword = "123";

		//执行SQL语句
		Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
		Statement stmt = con.createStatement();
		String sql = "select * from user where username='" + username + "' and password='" + password + "' ";
		ResultSet rs = stmt.executeQuery(sql);
		return rs.next();
	}

	/*
	 * 使用PreparedStatement后，可以防范SQL攻击
	 * 使用PreparedStatement的好处：
	 * 		1. 防范SQL攻击
	 * 		2. 可读性好
	 * 		3. 提高执行效率
	 */
	public static boolean login2(String username, String password) throws SQLException {
		//准备四大参数
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/exam?useServerPrepStmts=true&cachePrepStmts=true";
		String dbUsername = "root";
		String dbPassword = "123";

		//执行SQL语句
		Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM user WHERE username=? and password=?");

		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();

		return rs.next();
	}

	/*
	 * 测试login()：Statement不能防止SQL攻击。
	 */
	@Test
	public void func() throws SQLException {
		System.out.println(login("zhangsan", "123"));
		System.out.println(login("a' or 'a'='a", "a' or 'a'='a"));
	}
	/*
	 * 测试login2()：PreparedStatement可以防止SQL攻击。
	 */
	@Test
	public void func2() throws SQLException {
		System.out.println(login2("zhangsan", "123"));
		System.out.println(login2("a' or 'a'='a", "a' or 'a'='a"));
	}

	/*
	 * JdbcUtils类的使用
	 */
	@Test
	public void func3() {
		Connection con = JdbcUtils.getConnection();
		System.out.println(con);
	}
}
