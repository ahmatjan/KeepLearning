package cn.itcast.goods.user.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;

import cn.itcast.commons.CommonUtils;
import cn.itcast.goods.user.dao.UserDao;
import cn.itcast.goods.user.domain.User;
import cn.itcast.goods.user.service.exception.UserException;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

/**
 * 用户模块业务层
 * @author jason
 *
 */
public class UserService {
	private UserDao userDao = new UserDao();

	/**
	 * 校验用户名是否被注册
	 * @param loginname
	 * @return
	 */
	public boolean ajaxValidateLoginname(String loginname) {
		try {
			return userDao.ajaxValidateLoginname(loginname);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 校验email是否被注册
	 * @param email
	 * @return
	 */
	public boolean ajaxValidateEmail(String email) {
		try {
			return userDao.ajaxValidateEmail(email);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 进行注册
	 * @param user
	 */
	public void regist(User user) {
		/*
		 * 1.补齐其他数据（uid、状态、激活码）
		 * 2.调用userDao插入数据
		 * 3.发送邮件
		 */
		user.setUid(CommonUtils.uuid());
		user.setStatus(false);
		user.setActivationCode(CommonUtils.uuid() + CommonUtils.uuid());

		try {
			userDao.add(user);
		} catch (SQLException e2) {
			throw new RuntimeException(e2);
		}

		//加载配置文件
		Properties props = new Properties();
		try {
			props.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));
		} catch (IOException e1) {
			throw new RuntimeException(e1);
		}
		String host = props.getProperty("host");
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		String from = props.getProperty("from");
		String to = props.getProperty("to");
		String subject = props.getProperty("subject");
		String content = MessageFormat.format(props.getProperty("content"), user.getActivationCode());
		//获得Session
		Session session = MailUtils.createSession(host, username, password);
		//创建邮件
		Mail mail = new Mail(from, user.getEmail(), subject, content);
		//发送邮件
		try {
			MailUtils.send(session, mail);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 进行用户的激活
	 * @param activationCode
	 * @throws UserException
	 */
	public void activate (String activationCode) throws UserException {
		/*
		 * 1.调用userDao#findUserByActivationCode根据激活码查找用户，如果找到的是null，抛出异常：无效的激活码 ----over
		 * 2.查看返回的User状态是否为true，如果为true，抛出异常：该用户已激活 ----over
		 * 3.调用userDao#updateStatus()把更改用户的状态为true
		 */
		try {
			User user = userDao.findUserByActivationCode(activationCode);
			if (user == null)
				throw new UserException("无效的激活码！");
			else if (user.isStatus() == true)
				throw new UserException("该用户已激活，请不要二次激活！");
			else
				userDao.updateStatus(user, true);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 登陆方法
	 * @param formUser
	 * @return
	 */
	public User login(User formUser) {
		try {
			return userDao.findByNameAndPass(formUser);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改密码
	 * @param formUser
	 * @throws UserException 
	 */
	public void updatePassword(User formUser) throws UserException {
		/**
		 * 1.调用userDao#validateOldPass来校验旧密码是否正确
		 * 2.如果返回值为false，则抛出异常：当前密码错误
		 * 3.调用userDao#updatePassword来修改密码
		 */
		boolean flag;
		try {
			flag = userDao.validateOldPass(formUser.getUid(), formUser.getLoginpass());
			if (!flag)
				throw new UserException("当前密码错误");
			userDao.updatePassword(formUser.getUid(), formUser.getNewpass());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
