/*
 * 目的：学习增强for循环的使用。
 * 说明：增强for支持 数组 和实现 iterable接口 的类。
 */
package cn.itcast.basic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Demo7 {
	//对普通容器使用增强for循环
	@Test
	public void func() {
		List<String> list = new LinkedList<String>();
		list.add("ZhangSan");
		list.add("LiSi");
		list.add("WangWu");
		for (String name : list) {
			System.out.println(name);
		}
	}

	@Test
	public void func2() {
		Names names = new Names("ZhangSan LiSi WangWu ZhaoLiu");
		for (String name : names) {
			System.out.println(name);
		}
	}
}

class Names implements Iterable<String> {
	private String text;

	public Names(String text) {
		this.text = text;
	}

	//迭代器，每次返回一个名字
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			String[] names = text.split("\\s+");
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < names.length;
			}

			@Override
			public String next() {
				return names[index++];
			}
			@Override
			public void remove() {
				throw new UnsupportedOperationException("不支持该种操作");
			}
		};
	}
}
