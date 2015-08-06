/**
 * 说明：学习动态代理的案例。
 * 特点：继承，不能指定加强的对象，能指定加强的方法；
 * 			装饰者模式，能指定加强的对象，不能指定加强的方法；
 * 			动态代理，既能制定加强的对象，又能指定加强的方法。
 * 案例：加强ManWaiter类的serve()方法，前后分别加“你好！”和“再见”
 */
package cn.itcast.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class Demo2 {
	@Test
	public void fun1() {
		ManWaiter manWaiter = new ManWaiter();

		ClassLoader loader = this.getClass().getClassLoader();
		Class[] interfaces = new Class[]{Waiter.class};
		InvocationHandler h = new ManWaiterInvocationHandler(manWaiter);

		Object o = Proxy.newProxyInstance(loader, interfaces, h);

		Waiter waiterProxy = (Waiter) o;
		waiterProxy.serve();
	}
}

class ManWaiterInvocationHandler implements InvocationHandler {
	Waiter manWaiter = new ManWaiter();			//目标对象

	public ManWaiterInvocationHandler(ManWaiter manWaiter) {
		this.manWaiter = manWaiter;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("你好！");
		manWaiter.serve();
		System.out.println("再见！");

		return null;
	}
}