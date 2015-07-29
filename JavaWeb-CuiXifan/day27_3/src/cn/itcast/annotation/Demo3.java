/**
 * 说明：用 反射泛型和反射注解 来实现Hibernate原型。
 */
package cn.itcast.annotation;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.jdbc.TxQueryRunner;

public class Demo3 {
}

//回忆原本如何实现UserDao
class UserDaoA {
	private QueryRunner qr = new TxQueryRunner();

	//添加用户
	public void addUser(User user) throws SQLException {
		String sql = "";
		Object[] params = {};
		qr.update(sql, params);
	}

	//更改用户
	public void update(User user) throws SQLException {
		String sql = "";
		Object[] params = {};
		qr.update(sql, params);
	}
}

//使用注解之后的UserDao
class UserDaoB extends BaseDao<User> {
	public void addUser(User user) throws SQLException {
		add(user);
	}

	public void deleteUser(String userId) {
		delete(userId);
	}
}

//Hibernate的原型
class BaseDao<T> {
	private QueryRunner qr = new TxQueryRunner();

	//添加用户
	public void add(T bean) throws SQLException {
		String sql = "INSERT INTO table_name(column1, column2) values (?,?)";		
								//获取表名：如果实体类和表名相同，用反射泛型的方法获取表名；
								//		  如果使用了注解来映射实体类和表格，用反射注解的方式获取表名。
								//获取表的列名：用注解的反射来获取表的列名。
								//获取列数量：采用反射来获取列的数量。
		Object[] params = {};	//获取实体类成员变量值：用反射来获取实体类成员变量的值。
		qr.update(sql);
	}

	//更改用户
	public void update(T bean) {
	}

	//删除用户
	public void delete(String userId) {
	}

	//查找单个用户
	public T load(String userId) {
		return null;
	}

	//查找多个用户
	public List<T> findAll() {
		return null;
	}
}
