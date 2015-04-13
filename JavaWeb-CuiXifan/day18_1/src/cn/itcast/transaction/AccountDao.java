package cn.itcast.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDao {

	public void updateBalance(Connection con, String name, double money) {
		try {
			String sql = "update account set balance=balance+? where name=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, money);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
