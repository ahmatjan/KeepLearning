package cn.itcast.jdbc;

import java.sql.SQLException;

import org.junit.Test;

/*
 * 账户相关信息的业务层
 */
public class AccountService {
	private AccountDao dao = new AccountDao();

	/*
	 * 转账
	 */
	@Test
	public void transfer() {
		try {
			JdbcUtils.beginTransaction();
	
			dao.updateAccount("ZhangSan", -100);
		//	if (true) throw new RuntimeException("回滚吧");
			dao.updateAccount("LiSi", 100);
	
			JdbcUtils.commitTransaction();
		} catch (SQLException e) {
			try {
				JdbcUtils.rollback();
			} catch (SQLException e1) { }
			throw new RuntimeException(e);
		}
	}
}
