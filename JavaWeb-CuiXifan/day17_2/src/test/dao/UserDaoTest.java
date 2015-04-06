package test.dao;

import org.junit.Test;

import cn.itcast.user.dao.XmlUserDaoImpl;
import cn.itcast.user.domain.User;

public class UserDaoTest {
	@Test
	public void testFindByUsername() {
		XmlUserDaoImpl dao = new XmlUserDaoImpl();
		System.out.println(dao.findByUsername("张三"));
	}

	@Test
	public void testAddUser() {
		XmlUserDaoImpl dao = new XmlUserDaoImpl();
		User user = new User();
		user.setUsername("李四");
		user.setPassword("lisi");
		dao.addUser(user);
	}

}
