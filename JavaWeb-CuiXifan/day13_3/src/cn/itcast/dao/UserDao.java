package cn.itcast.dao;

import cn.itcast.domain.User;

public class UserDao {
	public User	find() {
		return new User("ZhangSan", "123");
	}
}
