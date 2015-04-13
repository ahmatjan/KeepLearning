package cn.itcast.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * v1.0
 */
public class JdbcUtils {
	private  static Properties props = null;

	static {
		//准备四大参数
		props = new Properties();
		InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
		try {
			props.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		//加载注册驱动类，返回连接
		try {
			Class.forName(props.getProperty("driverClassName"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() {
			try {
				return DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}
}
