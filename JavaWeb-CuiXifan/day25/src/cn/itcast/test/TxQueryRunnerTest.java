package cn.itcast.test;

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

import cn.itcast.commons.CommonUtils;
import cn.itcast.domain.Address;
import cn.itcast.domain.Person;
import cn.itcast.jdbc.JdbcUtils;
import cn.itcast.jdbc.TxQueryRunner;

/*
 * 测试TxQueryRunner
 */
public class TxQueryRunnerTest {
	//update(): 用来执行insert、delete、update方法
	@Test
	public void testUpdate() throws SQLException {
		QueryRunner qr = new TxQueryRunner();

		String sql = "INSERT INTO test VALUES (?,?,?,?,?)";
		Object params[] = {"1", "ZhangSan", 23, "male", 1};
		qr.update(sql, params);
	}

	//update(): 配合事物使用
	@Test
	public void testUpdate2() {
		try {
			JdbcUtils.beginTransaction();

			QueryRunner qr = new TxQueryRunner();

			String sql = "INSERT INTO test VALUES (?,?,?,?,?)";
			Object params[] = {"2", "LiSi", 32, "female", 2};
			qr.update(sql, params);

			if (true) throw new RuntimeException();

			params = new Object[]{"3", "Haha", 34, "male", 3};
			qr.update(sql, params);
			
			JdbcUtils.commitTransaction();
		} catch (Exception e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				throw new RuntimeException(e);
			}
		}
	}

	//query(): 单行结果映射到JavaBean中
	@Test
	public void testQuery1() throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "SELECT * FROM test WHERE id=?";
		Person p = qr.query(sql, new BeanHandler<Person>(Person.class), "1");
		System.out.println(p);
	}

	//query(): 多行结果集映射到List<JavaBean>中
	@Test
	public void testQuery2() throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "SELECT * FROM test WHERE name=?";
		List<Person> p = qr.query(sql, new BeanListHandler<Person>(Person.class), "ZhangSan");
		System.out.println(p);
	}
	//query(): 多行结果集映射到Map中
	@Test
	public void testQuery3() throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "SELECT * FROM test WHERE name=?";
		Map<String, Object> map = qr.query(sql, new MapHandler(), "ZhangSan");
		System.out.println(map);
	}
	//query(): 多行结果集映射到List<Map>中
	@Test
	public void testQuery4() throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "SELECT * FROM test WHERE name=?";
		List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), "ZhangSan");
		System.out.println(mapList);
	}

	//query(): 单行单列结果映射到Number中
	@Test
	public void testQuery5() throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "SELECT COUNT(*) FROM test";
		Number num = (Number) qr.query(sql, new ScalarHandler());
		System.out.println(num.intValue());
	}
	//单行表数据含两张表中的数据
	@Test
	public void testQuery6() throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "SELECT * FROM test p, t_address a WHERE p.aid=a.aid AND p.id=?";
		Map<String, Object> map = qr.query(sql, new MapHandler(), "1");
		Person p = CommonUtils.toBean(map, Person.class);
		Address a = CommonUtils.toBean(map, Address.class);
		p.setAddress(a);
		System.out.println(p);
	}
}
