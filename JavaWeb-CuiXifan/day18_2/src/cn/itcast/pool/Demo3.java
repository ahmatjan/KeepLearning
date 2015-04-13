package cn.itcast.pool;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * 练习使用c3p0
 */
public class Demo3 {
	//在代码中配置c3p0的参数
	@Test
	public void func() throws PropertyVetoException, SQLException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/exam");
		dataSource.setUser("root");
		dataSource.setPassword("123");

		dataSource.setMinPoolSize(3);
		dataSource.setMaxPoolSize(20);
		dataSource.setInitialPoolSize(20);
		dataSource.setAcquireIncrement(5);

		Connection con = dataSource.getConnection();
		System.out.println(con);
		con.close();
	}

	//在配置文件配置c3p0的参数
	@Test
	public void func2() throws SQLException {
		//在创建对象时，就会自动的加载配置文件，不需要我们来指定
		//配置文件需要满足两点要求：
		//	1. 在src文件夹下
		//	2. 名字为c3p0-config.xml
		ComboPooledDataSource dataSource = new ComboPooledDataSource();

		Connection con = dataSource.getConnection();
		System.out.println(con);

		con.close();
	}

	//用配置文件的指定子元素来配置c3p0的参数
	@Test
	public void func3() throws SQLException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource("oracle-config");

		Connection con = dataSource.getConnection();
		System.out.println(con);

		con.close();
	}
}
