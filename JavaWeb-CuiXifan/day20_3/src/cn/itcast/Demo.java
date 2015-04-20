package cn.itcast;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

/*
 * 学习使用ResourceBundle来实现国际化！
 * 	1. ResourceBundle需要 Locale 和 资源文件 来发挥作用
 * 	2. Locale有多种构造方法，如
 * 		new Locale("zh", "CN"); 
 * 		Locale.getDefault()
 * 		Locale.US
 * 	3. 资源文件的命名规则为：
 * 		基本名称 + Locale名称 + .properties
 */

public class Demo {
	@Test
	public void func() {
		//Locale locale = Locale.US;
		Locale locale = Locale.CHINA;
		ResourceBundle rb = ResourceBundle.getBundle("res", locale);

		System.out.println(rb.getString("username"));
		System.out.println(rb.getString("password"));
		System.out.println(rb.getString("login"));
	}
}
