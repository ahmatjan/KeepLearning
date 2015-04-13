/*
 * 没有学习DBUtils之前进行数据库的增删改查
 */
package cn.itcast.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.itcast.jdbc.JdbcUtils;

public class Demo {
	@Test
	public void addStu(Stu stu) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection();
			String sql = "INSERT INTO t_stu VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stu.getSid());
			pstmt.setString(2, stu.getSname());
			pstmt.setInt(3, stu.getAge());
			pstmt.setString(4, stu.getGender());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			//处理异常
		} finally {
			//关闭资源
		}
	}

	//修改、删除 和 插入类似

	@Test
	public Stu load(int sid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM t_stu WHERE sid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();
			if(!rs.next()) return null;

			Stu stu = new Stu();
			stu.setSid(rs.getInt(1));
			stu.setSname(rs.getString(2));
			stu.setAge(rs.getInt(3));
			stu.setGender(rs.getString(4));

			return stu;
		} catch (SQLException e) {
			//处理异常
		} finally {
			//关闭资源
		}
		return null;
	}

}
