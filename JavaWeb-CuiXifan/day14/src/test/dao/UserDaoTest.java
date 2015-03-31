package test.dao;

import org.junit.Test;

import cn.itcast.user.dao.UserDao;
import cn.itcast.user.domain.User;

public class UserDaoTest {
	@Test
	public void testFindByUsername() {
		UserDao dao = new UserDao();
		System.out.println(dao.findByUsername("张三"));
	}

	@Test
	public void testAddUser() {
		UserDao dao = new UserDao();
		User user = new User();
		user.setUsername("李四");
		user.setPassword("lisi");
		dao.addUser(user);
	}

}
