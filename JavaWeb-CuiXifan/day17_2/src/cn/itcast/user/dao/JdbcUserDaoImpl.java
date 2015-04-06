package cn.itcast.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.itcast.user.domain.User;

public class JdbcUserDaoImpl implements UserDao {
	private Connection con = null;
	private PreparedStatement  pstmt = null;
	private ResultSet rs = null;

	public User findByUsername(String username) {
		con = JdbcUtils.getConnection();
		try {
			pstmt = con.prepareStatement("SELECT * FROM user WHERE username=?");
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();

			if (rs == null) return null;
			if (!rs.next()) return null;

			//ORM转换
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (rs != null) { rs.close(); }
				if (pstmt != null) { pstmt.close(); }
				if (con != null) { con.close(); }
			} catch (SQLException e) { } 
		}
	}

	public void addUser(User user) {
		con = JdbcUtils.getConnection();

		try {
			pstmt = con.prepareStatement("INSERT INTO user VALUES(?, ?)");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (rs != null) { rs.close(); }
				if (pstmt != null) { pstmt.close(); }
				if (con != null) { con.close(); }
			} catch (SQLException e) { } 
		}
	}
}
