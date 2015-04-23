package cn.itcast.web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AListener implements ServletContextListener {

    public AListener() { }

    //在ServletContext初始化时，把map放入ServletContext中
    public void contextInitialized(ServletContextEvent sce)  { 
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	ServletContext application = sce.getServletContext();
    	application.setAttribute("map", map);
    }

    public void contextDestroyed(ServletContextEvent sce)  { }
	
}
