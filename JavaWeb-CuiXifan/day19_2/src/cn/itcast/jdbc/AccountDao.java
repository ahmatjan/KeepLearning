package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

/*
 * 修改账户相关信息的Dao
 * 
 * 注：Dao层获取连接时，可以把连接当做非事物的连接，只要用完后releaseConnection即可。
 */
public class AccountDao {

	/*
	 * 更改账户余额
	 */
	public void updateAccount(String account, int money) throws SQLException {
		//QueryRunner qr = new QueryRunner();
		QueryRunner qr = new TxQueryRunner();
		String sql = "UPDATE account SET balance=balance+? WHERE name=?";
		Object[] params = {money, account};

		//Connection con = JdbcUtils.getConnection();
		//qr.update(con, sql, params);
		//JdbcUtils.releaseConnection(con);
		qr.update(sql, params);
	}

}
