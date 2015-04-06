/*
 * 说明：用数据库进行大文件的存取。
 */
package cn.itcast.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class Demo4 {

	/*
	 * 大文件的存放
	 */
	@Test
	public void func1() throws SQLException, FileNotFoundException, IOException {
		Connection con = JdbcUtils.getConnection();
		String sql = "INSERT INTO song values(?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 1);
		pstmt.setString(2, "流光飞舞.mp3");
		pstmt.setBlob(3, new FileInputStream("/tmp/流光飞舞.mp3"));
		pstmt.executeUpdate();
	}

	/*
	 * 大文件的取出
	 */
	@Test
	public void func2() throws SQLException, IOException {
		Connection con = JdbcUtils.getConnection();
		String sql = "SELECT * FROM song WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 1);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			Blob blob = rs.getBlob("content");
			InputStream in = blob.getBinaryStream();
			FileOutputStream out = new FileOutputStream("/tmp/lgfw.mp3");
			IOUtils.copy(in, out);
		}
	}

}
