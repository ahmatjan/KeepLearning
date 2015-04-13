/*
 * 说明：用转账来演示transaction的使用
 */
package cn.itcast.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import cn.itcast.jdbc.JdbcUtils;

public class Demo {
	//转账函数
	public void transfer(String from, String to, double money) {
		AccountDao accountDao = new AccountDao();
		Connection con = JdbcUtils.getConnection();
		try {
			con.setAutoCommit(false);
			accountDao.updateBalance(con, from, -money);
		//	if (true)
		//		throw new RuntimeException("抛出异常～！");
			accountDao.updateBalance(con, to, money);
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {}
		}
	}

	//调用转账函数进行测试
	@Test
	public void fun() {
		transfer("ZhangSan", "LiSi", 200);
	}
}