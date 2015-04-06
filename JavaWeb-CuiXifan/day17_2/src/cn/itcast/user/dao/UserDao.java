package cn.itcast.user.dao;

import cn.itcast.user.domain.User;

public interface UserDao {
	public User findByUsername(String username);
	public void addUser(User user);
}
