package cn.itcast.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MyQueryRunner<T> {
	private DataSource dataSource;

	public MyQueryRunner(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	//进行增删改
	public int update(String sql, Object... params) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);

			//为pstmt赋参数
			setParameter(pstmt, params);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (pstmt != null) {pstmt.close();}
				if (con != null) {con.close();}
			} catch (Exception e) {}
		}
	}

	//进行查询
	public T query(String sql, RsHandler<T> rh, Object... params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			setParameter(pstmt, params);
			rs = pstmt.executeQuery();
			return rh.handle(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//给pstmt赋参数
	private void setParameter(PreparedStatement pstmt, Object... params)
			throws SQLException {
		for (int i = 0; i < params.length; i++) {
			pstmt.setObject(i+1, params[i]);
		}
	}
}

interface RsHandler<T> {
	public T handle(ResultSet rs) throws SQLException;
}