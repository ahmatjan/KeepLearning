package cn.itcast.goods.admin.admin.service;

import java.sql.SQLException;

import cn.itcast.goods.admin.admin.dao.AdminDao;
import cn.itcast.goods.admin.admin.domain.Admin;

/**
 * 管理员模块业务层
 * @author jason
 *
 */
public class AdminService {
	private AdminDao adminDao = new AdminDao();


	/**
	 * 管理模块登陆
	 * @param adminname
	 * @param adminpass
	 * @return
	 */
	public Admin login(String adminname, String adminpwd) {
		try {
			return adminDao.findAdminByNameAndPass(adminname, adminpwd);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
