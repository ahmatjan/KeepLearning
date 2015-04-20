package cn.itcast.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/*
 * 说明：
 * 	学习ServletContextAttributeListener监听器的使用。
 */
public class BListener implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent scab)  { 
    	System.out.println("application中添加值： " + scab.getName() + "=" + scab.getValue());
    }

    public void attributeReplaced(ServletContextAttributeEvent scab)  { 
    	System.out.println("application中修改值： " + scab.getName() + "=" + scab.getValue());
    	System.out.println("现在值为：" + scab.getServletContext().getAttribute(scab.getName()));
    }

    public void attributeRemoved(ServletContextAttributeEvent scab)  { 
    	System.out.println("application中删除值： " + scab.getName() + "=" + scab.getValue());
    }
	
}
