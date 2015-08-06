/**
 * 说明：学习 注解@WebListener 
 */
package cn.itcast.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("死掉了！");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("出生了！");
	}

}
