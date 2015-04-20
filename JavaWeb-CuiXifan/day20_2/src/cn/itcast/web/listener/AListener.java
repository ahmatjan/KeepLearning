package cn.itcast.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/*
 * 说明：
 * 	学习使用ServletContext的生死监听器。
 */
public class AListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("哇，我来也！");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("哇，我要挂了！");
	}
}
