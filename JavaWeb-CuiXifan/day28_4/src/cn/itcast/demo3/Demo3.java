/**
 * 说明：代理工厂的实现
 * 特点：代理对象 = 目标对象 + 增强
 * 		动态代理的目的是，让目的对象和增强都可以切换！
 * 使用：1.创建代理工厂
 * 		2.设置工厂的目标对象、前置增强、后置增强
 * 		3.调用createProxy()得到代理对象
 * 		4.强转代理对象，调用方法
 * 效果：执行目标对象的目标方法时，
 * 		1.执行前置增强
 * 		2.执行目标方法
 * 		3.执行后置增强
 */
package cn.itcast.demo3;

import org.junit.Test;

public class Demo3 {
	@Test
	public void fun1() {
		ProxyFactory factory = new ProxyFactory();
		ManWaiter manWaiter = new ManWaiter();

		// 设置代理工厂
		factory.setTargetObject(manWaiter);
		factory.setBeforeAdvice(new BeforeAdvice() {
			public void before() {
				System.out.println("你好");
			}
		});
		factory.setAfterAdvice(new AfterAdvice() {
			public void after() {
				System.out.println("再见");
			}
		});

		// 创建代理对象
		Waiter waiter = (Waiter) factory.createProxy();
		// 调用代理对象方法
		waiter.serve();
	}
}
