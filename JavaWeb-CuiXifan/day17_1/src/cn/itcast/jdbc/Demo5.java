/*
 * 说明：学习PreparedStatement的批处理
 */
package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;


public class Demo5 {
	@Test
	public void func() throws SQLException {
		Connection con = JdbcUtils.getConnection();
		String sql = "INSERT INTO test VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		for (int i = 0; i < 10000; i ++) {
			pstmt.setString(1, "ITCAST_" + i);
			pstmt.setString(2, "stu_" + i);
			pstmt.setInt(3, 20 + i % 20);
			pstmt.setString(4, i % 2 == 1 ? "male" : "female");
			pstmt.addBatch();
		}

		long start = System.currentTimeMillis();
		pstmt.executeBatch();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
