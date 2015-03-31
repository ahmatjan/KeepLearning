/*
 * 说明：逻辑类
 */
package cn.itcast.user.service;

import cn.itcast.user.dao.UserDao;
import cn.itcast.user.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();

	/*
	 * 注册
	 * 
	 * 调用userDao的findByUsername()
	 * 		如果返回值为空，则添加该用户
	 * 		如果返回值不为空，则抛出异常
	 */
	public void regist(User user) throws UserException {
		if (userDao.findByUsername(user.getUsername()) == null) {
			userDao.addUser(user);
		} else {
			throw new UserException("该用户已经存在！");
		}
	}

	/*
	 * 登陆
	 * 
	 * 	 调用UserDao中的findByUsername()
	 * > 返回null，则抛出异常“用户不存在”
	 * > 返回不为null，比较密码是否正确
	 *  	>> 密码错误，抛出异常“密码错误”
	 *  	>> 密码正确，返回User对象
	 */
	public User login(User user) throws UserException {
		User userInfo = userDao.findByUsername(user.getUsername());
		if ( userInfo == null) {
			throw new UserException("用户不存在");
		} else {
			if (!userInfo.getPassword().equals(user.getPassword())) {
				throw new UserException("用户密码错误");
			} else {
				return userInfo;
			}
		}
	}
}
