package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();

	public User find() {
		return userDao.find();
	}
}
