package cn.itcast.web.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/*
 * 说明：
 * 	学习HttpSessionBindingListener
 * 		1. 该监听器在JavaBean中实现
 * 		2. 不需要在web.xml中注册
 */
public class UserA implements HttpSessionBindingListener {
	private String username;
	private String passwd;


	@Override
	public String toString() {
		return "UserA [username=" + username + ", passwd=" + passwd + "]";
	}


	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("啊～可爱的Session添加了我！");
	}

	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("哇～无情的Session抛弃了我！");
	}

}
