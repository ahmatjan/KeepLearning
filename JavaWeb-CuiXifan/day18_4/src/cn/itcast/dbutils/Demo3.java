/*
 * 说明：练习DBUtils的使用。
 */
package cn.itcast.dbutils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.itcast.jdbc.JdbcUtils;

public class Demo3 {
	//增删改
	@Test
	public void func() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "INSERT INTO t_stu VALUES(?,?,?,?)";
		Object[] params = {345, "LiSi", 34, "female"};

		qr.update(sql, params);
	}

	//查询单行
	@Test
	public void func2() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT * FROM t_stu WHERE sid=?";
		Object[] params = {22};
		Stu stu = qr.query(sql, new BeanHandler<Stu>(Stu.class), params);
		System.out.println(stu);
	}

	//查询多行记录
	@Test
	public void func3() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT * FROM t_stu";
		List<Stu> stuList = qr.query(sql, new BeanListHandler<Stu>(Stu.class));
		System.out.println(stuList);
	}

	//查询单行记录，并转换为map
	@Test
	public void func4() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT * FROM t_stu WHERE sid=?";
		Object[] params = {22};
		Map map = qr.query(sql, new MapHandler(), params);
		System.out.println(map);
	}

	//查询多行记录，并转换为List<Map>
	@Test
	public void func5() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT * FROM t_stu";
		List<Map<String, Object>> listMap = qr.query(sql, new MapListHandler());
		System.out.println(listMap);
	}

	//查询单行单列记录
	@Test
	public void func6() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT COUNT(*) FROM t_stu";
		Number num = (Number)qr.query(sql, new ScalarHandler());
		System.out.println(num);
	}

}
