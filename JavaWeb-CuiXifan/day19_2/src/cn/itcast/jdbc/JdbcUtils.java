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

	//事物专用Connection
	//private static Connection con;	
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();		//用ThreadLocal避免并发问题

	/*
	 * 返回连接：
	 * 	如果正在进行事物，则返回事物专用连接。
	 * 	否则返回普通连接
	 */
	public static Connection getConnection() throws SQLException {
		Connection con = tl.get();
		if (con != null)
			return con;
		else
			return dataSource.getConnection();
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	/*
	 * 开始事物
	 */
	public static void beginTransaction() throws SQLException {
		Connection con = tl.get();
		if (con != null)
			throw new RuntimeException("您已经开起了事物，请不要重复开启！");
		con = getConnection();
		con.setAutoCommit(false);
		tl.set(con);
	}

	/*
	 * 提交事物
	 */
	public static void commitTransaction() throws SQLException {
		Connection con = tl.get();
		if (con == null)
			throw new RuntimeException("您还没有开启事物，不能进行该操作！");
		con.commit();
		con.close();
		tl.remove();
	}

	/*
	 * 事物回滚
	 */
	public static void rollback() throws SQLException {
		Connection con = tl.get();
		if (con == null)
			throw new RuntimeException("您还没有开启事物，不能进行该操作！");
		con.rollback();
		tl.remove();
	}

	/*
	 * 释放连接
	 * 	如果连接不是事物专用的连接，就关闭
	 * 	如果是事物专用的，不关闭
	 */
	public static void releaseConnection(Connection con2) throws SQLException {
		Connection con = tl.get();
		if (con == null || con != con2) {
			con2.close();
		}
	}
}
