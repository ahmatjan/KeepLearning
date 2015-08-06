/**
 * 说明：学习 动态代理
 * 	> 是什么：动态创建实现了制定一组接口的实现类对象
 * 	> 怎么用：主要使用 nexProxyInstance()这一函数
 */
package cn.itcast.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class Demo1 {
	@Test
	public void fun1() {
		// 准备三大参数
		ClassLoader loader = this.getClass().getClassLoader(); 			// 第一大参数，用来加载类的"黑白无常"
		Class[] interfaces = new Class[] { A.class, B.class }; 			// 第二大参数，实现的接口
		InvocationHandler h = new InvocationHandler() { 				// 第三大参数，调用接口函数时将调用的方法
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				System.out.println("你好，动态代理！");
				return "xxx";
			}
		};

		// 创建代理对象
		Object o = Proxy.newProxyInstance(loader, interfaces, h);

		// 强转
		A a = (A) o;
		B b = (B) o;

		// 调用方法
		a.fa();
		System.out.println(b.fb());
	}
}

interface A {
	public void fa();
	public void faa();
}

interface B {
	public String fb();
	public String fbb();
}