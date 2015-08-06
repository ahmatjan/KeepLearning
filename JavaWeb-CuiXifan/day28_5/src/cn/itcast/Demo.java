/**
 * 说明：1.该例子运行后，Failure Trace会列出函数的调用列表
 * 		2.JDK的ClassLoader分为三类：系统、拓展、引导
 * 		3.JDK类加载器机制：时采用的是“委托机制”：找类时先让父-类加载器来找，找不到自己再找
 * 		4.Tomcat的ClassLoader多加了两类：应用（WEB-INF/classes和WEB-INF/lib）、服务器（Tomcat/lib）、系统、拓展、引导
 * 		5.Tomcat的类加载器机制：采用的是“覆盖机制”，自己先加载，找不到再让父类加载
 * 		4.自定义ClassLoader：继承ClassLoader类，覆盖findClass()方法
 * 
 */
package cn.itcast;

import org.junit.Test;

public class Demo {
	@Test
	public void fun1() throws ClassNotFoundException {
		Class.forName("jfwlef");
	}
	/*
	 * java.lang.ClassNotFoundException: jfwlef
	at java.net.URLClassLoader$1.run(URLClassLoader.java:366)
	at java.net.URLClassLoader$1.run(URLClassLoader.java:355)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.net.URLClassLoader.findClass(URLClassLoader.java:354)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:425)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:308)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:358)
	at java.lang.Class.forName0(Native Method)
	at java.lang.Class.forName(Class.java:190)
	at cn.itcast.Demo.fun1(Demo.java:8)
	 */
}
