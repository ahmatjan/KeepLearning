/*
 * 说明：连接mysql数据库
 */
package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;


public class Demo1 {
	@Test
	public void f() throws ClassNotFoundException, SQLException {
		/*
		com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
		*/
		Class.forName("com.mysql.jdbc.Driver");	//加载、注册驱动类。效果和上面两句等效
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "123");
		System.out.println(con);
	}
}
