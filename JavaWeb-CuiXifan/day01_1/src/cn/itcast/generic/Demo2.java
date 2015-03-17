/*
 * 目的：练习泛型方法的使用。
 * 说明：
 * 		1. 泛型方法不受类的限制，也就是说所在类是否为泛型类无所谓。
 * 		2. 泛型类的格式： 修饰符 <T> 返回值 方法名() {}
 * 		3. 泛型方法特点：在参数中使用反省，在返回值中返回泛型。
 */
package cn.itcast.generic;

import org.junit.Test;

public class Demo2 {
	@Test
	public void func1() {
		String name = AA.<String>getMid(new String[] {"ZhangSan", "LiSi", "WangWu"});
		System.out.println(name);
	}
}

class AA {
	public static <T> T getMid(T[] arr) {
		return arr[arr.length/2];
	}
}
