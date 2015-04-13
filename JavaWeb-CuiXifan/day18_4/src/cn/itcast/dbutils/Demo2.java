/*
 * 测试自己实现的MyQueryRunner
 */
package cn.itcast.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.itcast.jdbc.JdbcUtils;

public class Demo2 {

	@Test
	public void func1() {
		addStu(new Stu(22, "ZhangSan", 88, "male"));
		System.out.println(load(22));
	}

	//添加学生
	public void addStu(Stu stu) {
		String sql = "INSERT INTO t_stu VALUES (?,?,?,?)";
		MyQueryRunner mqr = new MyQueryRunner(JdbcUtils.getDataSource());
		Object[] params = {stu.getSid(), stu.getSname(), stu.getAge(), stu.getGender()};
		mqr.update(sql, params);
	}

	//增删改都一样

	//查询学生
	public Stu load(int sid) {
		String sql = "SELECT * FROM t_stu WHERE sid=?";
		MyQueryRunner<Stu> mqr = new MyQueryRunner<Stu>(JdbcUtils.getDataSource());
		Object[] params = {sid};


		//定义转换接口
		RsHandler<Stu> rh = new RsHandler<Stu>() {
			public Stu handle(ResultSet rs) throws SQLException {
				if (!rs.next()) return null;
				Stu stu = new Stu();
				stu.setSid(rs.getInt(1));
				stu.setSname(rs.getString(1));
				stu.setAge(rs.getInt(1));
				stu.setGender(rs.getString(1));
				return stu;
			}
		};

		return mqr.query(sql, rh, params);
	}
}
