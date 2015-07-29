/**
 * 说明：学习工厂，面向接口编程
 */
package cn.itcast;

import org.junit.Test;

import cn.itcast.beanfactory.BeanFactory;
import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;
import cn.itcast.service.StudentService;

public class Demo1 {
	// 学习BeanFactory
	@Test
	public void fun1() {
		/*
		 * 1.创建domain对象
		 * 2.编写xml文件
		 * 3.创建工厂，同时指定配置文件
		 * 4.从工厂中获取对象
		 */
		BeanFactory bf = new BeanFactory("beans.xml"); 	// 创建工厂，同时制定配置文件
		Student stu1 = (Student) bf.getBean("stu1"); 	// 从工厂中获取对象

		Student stu11 = (Student) bf.getBean("stu1");
		System.out.println(stu1 == stu11); 				// 工厂中的对象是单例的
	}

	// 学习BeanFactory的ref属性值
	@Test
	public void fun2() {
		BeanFactory bf = new BeanFactory("beans.xml");
		Student stu1 = (Student) bf.getBean("stu1");
		Student stu2 = (Student) bf.getBean("stu2");
		System.out.println(stu1.getTeacher() == stu2.getTeacher());
	}

	// 面向接口编程Dao
	@Test
	public void fun3() {
		BeanFactory bf = new BeanFactory("beans.xml");
		StudentDao stuDao = (StudentDao) bf.getBean("stuDao");
		stuDao.addStudent(null);
		stuDao.updateStudent(null);
	}

	// 面向接口编程Service
	@Test
	public void fun4() {
		BeanFactory bf = new BeanFactory("beans.xml");
		StudentService stuService = (StudentService) bf.getBean("stuService");
		stuService.login();
	}

}
