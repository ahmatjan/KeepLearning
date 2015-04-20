package cn.itcast.web.listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/*
 * 说明：
 * 	学习HttpSessionActivationListener监听器的使用。
 * 		1. 要使用该监听器，JavaBean还需要implements Serializable接口
 * 		2. 钝化有两种情况，一种是服务器关闭时钝化，另一种是在Context中设置超时钝化。
 */
public class UserB implements HttpSessionActivationListener, Serializable {
	private String username;
	private String passwd;

    public void sessionWillPassivate(HttpSessionEvent arg0)  { 
    	System.out.println("地球太危险，我和Sesson去火星了～！");
    }

    public void sessionDidActivate(HttpSessionEvent arg0)  { 
    	System.out.println("地球很安全，我和Sesson从火星回来了～！");
    }
}
