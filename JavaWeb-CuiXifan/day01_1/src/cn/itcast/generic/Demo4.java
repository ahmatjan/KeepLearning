/*
 * 目的：探究泛型的擦除。
 * 说明：泛型是编译器特性，是编译器为我们做了强转。
 */
package cn.itcast.generic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Demo4 {
	@Test
	public void func() {
		List<String> list = new ArrayList<String>();
		list.add("haha");
		String temp = list.get(0);
	}
	/*
	 * 反汇编结果：
        List list = new ArrayList();
        list.add("haha");
        String temp = (String)list.get(0);
	 */
}
