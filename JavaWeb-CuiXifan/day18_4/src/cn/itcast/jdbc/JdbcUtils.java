/*
 * 用c3p0来改进JdbcUtils，注意要给出c3p0-config.xml
 */
package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	//注意要同时给出"c3p0-config.xml"文件！！
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

}
