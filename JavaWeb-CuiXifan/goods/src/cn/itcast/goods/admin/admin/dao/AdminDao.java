package cn.itcast.goods.admin.admin.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.goods.admin.admin.domain.Admin;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * 管理员模块实体类
 * @author jason
 *
 */
public class AdminDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 根据用户名和密码返回管理员
	 * @param adminname
	 * @param adminpass
	 * @return
	 * @throws SQLException 
	 */
	public Admin findAdminByNameAndPass(String adminname, String adminpwd) throws SQLException {
		String sql = "SELECT * FROM t_admin WHERE adminname=? AND adminpwd=?";
		Admin admin = qr.query(sql, new BeanHandler<Admin>(Admin.class), adminname, adminpwd);

		return admin;
	}

}
