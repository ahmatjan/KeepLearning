package cn.itcast.thread;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 * 用来学习ThreadLocal
 */
public class Demo {
	//ThreadLocal的使用
	@Test
	public void func() {
		/*
		 * ThreadLocal通常用于一个类的成员变量
		 * 当多个线程访问它时，每个线程都有自己的副本，互不干扰
		 */
		final ThreadLocal<String> tl = new ThreadLocal<String>();

		new Thread() {
			public void run() {
				tl.set("set...");
				System.out.println("Inner Class: " + tl.get());
			}
		}.start();

		System.out.println("Outer Class: " + tl.get());
	}

	//ThreadLocal的原理，模拟ThreadLocal的效果
	@Test
	public void func2() {
		final Map<Thread, String> map = new HashMap<Thread, String>();

		new Thread() {
			public void run() {
				map.put(Thread.currentThread(), "set...");
				System.out.println("Inner Class: " + map.get(Thread.currentThread()));
			}
		}.start();

		System.out.println("Outer Class: " + map.get(Thread.currentThread()));
	}
}

/*
 * 用来模拟实现ThreadLocal类
 */
class MyThreadLocal<T> {
	private Map<Thread, T> map = new HashMap<Thread, T>();

	public void set(T data) {
		map.put(Thread.currentThread(), data);
	}

	public T get() {
		return map.get(Thread.currentThread());
	}

	public void remove() {
		map.remove(Thread.currentThread());
	}
}
