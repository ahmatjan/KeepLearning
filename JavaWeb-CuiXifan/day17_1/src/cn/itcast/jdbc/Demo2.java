/*
 * 说明：
 * 		1. 对数据库进行 增删改查，
 * 		2. 数据库的规范化用法，行光标的MetaData的使用，可滚动的ResultSet。
 */
package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.RuntimeErrorException;

import org.junit.Test;

public class Demo2 {
	/*
	 * 数据库增删改，使用executeUpdate
	 */
	@Test
	public void fun() throws ClassNotFoundException, SQLException {
		//准备四大参数
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/exam";
		String username = "root";
		String password = "123";

		//获得Connection
		Class.forName(driverClassName);
		Connection con = DriverManager.getConnection(url, username, password);

		//获得Statement，用executeUpdate进行sql语句
		Statement stmt = con.createStatement();
		String sql = "INSERT INTO test VALUES ('ITCAST_0001', 'ZhangSan', 22, 'male')";
		String sql2 = "UPDATE test SET age=23 WHERE id='ITCAST_0001'";
		int rowsCount = stmt.executeUpdate(sql2);
		System.out.println(rowsCount);

		//关闭资源
		stmt.close();
		con.close();
	}

	/*
	 * 数据库查询，使用executeQuery
	 */
	@Test
	public void func2() throws ClassNotFoundException, SQLException {
		//准备四大参数
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/exam";
		String username = "root";
		String password = "123";

		//获得Connection
		Class.forName(driverClassName);
		Connection con = DriverManager.getConnection(url, username, password);

		//获得Statement，执行sql语句
		Statement stmt = con.createStatement();
		String sql = "select * from test";
		ResultSet rs = stmt.executeQuery(sql);
		
		//遍历输入结果
		while (rs.next()) {
			System.out.println(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4));
		}
		System.out.println("");

		//关闭资源
		rs.close();
		stmt.close();
		con.close();
	}

	/*
	 *  数据库的规范化用法，行光标的MetaData的使用，可滚动的ResultSet。
	 */
	@Test
	public void func3() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/exam";
		String username = "root";
		String password = "123";

		try {
			//执行SQL
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			String sql = "SELECT * FROM test";
			rs = stmt.executeQuery(sql);

			//遍历结果集
			int count = rs.getMetaData().getColumnCount();	//使用MetaData获取列数
			//每行遍历
			while (rs.next()) {
				//每列遍历
				for (int i = 0; i < count; i++) {
					System.out.print(rs.getString(i + 1));
					if (i < count - 1) System.out.print(", ");
				}
				System.out.println();
			}

			// ResultSet的可滚动性的练习。
			// mysql默认是可滚动的，其他数据库需要在 con.createStatement时指定为可滚动的。
			rs.last();													//把光标移动到最后一行
			System.out.println(rs.getRow());		//打印当前行数
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			//关闭资源，防止资源泄露
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();
			} catch(Exception e) {}
		}
	}

}
