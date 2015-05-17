package cn.itcast.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import cn.itcast.jdbc.JdbcUtils;

/*
 * 测试JdbcUtils
 * 	> 依赖c3p0
 * 	> 依赖mysql
 * 	> 需要c3p0-config.properties
 */
public class JdbcUtilsTest {
	//测试获取释放连接
	@Test
	public void testGetConnection() throws SQLException {
		//获得连接
		Connection con = JdbcUtils.getConnection();
		System.out.println(con);

		//释放连接
		JdbcUtils.releaseConnection(con);
		System.out.println(con.isClosed());
	}

	//测试Transaction
	@Test
	public void testTransaction() {
		try {
			JdbcUtils.beginTransaction();			//开启事物
			/*多次操作*/
			JdbcUtils.commitTransaction();			//提交事物
		} catch (SQLException e) {
			try {
				JdbcUtils.rollbackTransaction();	//回滚事物
			} catch (SQLException e1) {
				throw new RuntimeException(e);
			}
		}
	}
}
