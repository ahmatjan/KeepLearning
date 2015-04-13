/*
 * 说明：练习使用dbcp连接池。
 */
package cn.itcast.pool;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

public class Demo {
	@Test
	public void func() throws SQLException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/exam");
		dataSource.setUsername("root");
		dataSource.setPassword("123");

		dataSource.setMaxActive(20);
		dataSource.setMinIdle(3);
		dataSource.setMinIdle(1000);

		Connection con = dataSource.getConnection();
		System.out.println(con.getClass().getName());

		//把connection归还给连接池
		con.close();
	}
}
