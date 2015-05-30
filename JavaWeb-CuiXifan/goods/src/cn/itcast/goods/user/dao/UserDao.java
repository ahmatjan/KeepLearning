package cn.itcast.goods.user.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.goods.user.domain.User;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * 用户模块的持久层
 * @author jason
 *
 */
public class UserDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 校验用户名是否被注册
	 * @param loginname
	 * @return
	 * @throws SQLException
	 */
	public boolean ajaxValidateLoginname(String loginname) throws SQLException {
		String sql = "SELECT COUNT(*) FROM t_user WHERE loginname=?";
		Number num = (Number) qr.query(sql, new ScalarHandler(), loginname);
		return num.intValue() == 0;
	}

	/**
	 * 校验Emai是否被注册
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public boolean ajaxValidateEmail(String email) throws SQLException {
		String sql = "SELECT COUNT(*) FROM t_user WHERE email=?";
		Number num = (Number) qr.query(sql, new ScalarHandler(), email);
		return num.intValue() == 0;
	}

	/**
	 * 向数据库中添加用户
	 * @param user
	 * @throws SQLException 
	 */
	public void add(User user) throws SQLException {
		String sql = "INSERT INTO t_user VALUES (?,?,?,?,?,?)";
		Object[] params = {user.getUid(), user.getLoginname(), user.getLoginpass(), 
				user.getEmail(), user.isStatus(), user.getActivationCode()};
		qr.update(sql, params);
	}

}
