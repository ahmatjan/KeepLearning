/*
 * 说明：面向接口编程，通过一个工厂类，返回配置文件的UserDao实现类的对象。
 */
package cn.itcast.user.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.itcast.user.dao.UserDao;

public class UserDaoFactory {
	private static Properties props = null;

	static {
		props = new Properties();
		InputStream in = UserDaoFactory.class.getClassLoader().getResourceAsStream("userdaoconfig.properties");
		System.out.println(in);
		try {
			props.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static UserDao getUserDao() {
		try {
			System.out.println(props.getProperty("cn.itcast.user.dao.UserDao"));
			Class clazz = Class.forName(props.getProperty("cn.itcast.user.dao.UserDao"));
			UserDao userDao = (UserDao) clazz.newInstance();
			return userDao;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
