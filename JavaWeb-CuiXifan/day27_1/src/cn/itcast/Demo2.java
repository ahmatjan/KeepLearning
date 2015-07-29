/**
 * 说明：学习使用通配符
 */
package cn.itcast;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Demo2 {
	//1. 数组和集合的PK
	@Test
	public void fun1() {
		//第一回合
		Object[] objs = new Object[10];
		List objList = new ArrayList();

		//第二回合
		String[] strs = new String[10];
		List strList = new ArrayList<String>();

		//第三回合
		Object[] objs2 = new String[10];
//		objs2[0] = new String[10];							//运行时异常：ArrayStoreException

//		List<Object> objList2 = new ArrayList<Integer>();	//编译时错误：TypeMismatch   —— 泛型使用时，等号左边和右边的类型变量必须一致。
//		objList2.add(new Integer(100));
	}

	//2. 引入通配符
	@Test
	public void fun2() {
		List<Integer> intList = new ArrayList<Integer>();
		List<String> strList = new ArrayList<String>();

		print(intList);
		print(strList);
	}

//	public void print(List<Object> list) {}					//不能使用泛型Object来实现一个万能方法，必须使用通配符来实现
	public void print(List<?> list) {
//		list.add("hello");			//通配符缺点1：不能使用泛型类中的某些方法（参数为泛型的方法）
		Object o = list.get(0);		//通配符缺点2：不能使用泛型类中的某些方法（返回值为泛型的方法）
	}

	//3. 引入子类限定的通配符
	@Test
	public void fun3() {
		List<Integer> intList = new ArrayList<Integer>();
		List<Long> longList = new ArrayList<Long>();

		print2(intList);
		print2(longList);
	}

	public void print2(List<? extends Number> list) {
//		list.add("hello");			//子类限定通配符缺点：不能使用泛型类中的某些方法（参数为泛型的方法）
		Number num = list.get(0);	//子类限定通配符有点：可以使用泛型类中的某些方法（返回值为泛型的方法）
	}

	//4. 引入父类限定的通配符
	@Test
	public void fun4() {
		List<Object> objList = new ArrayList<Object>();
		List<Number> numList = new ArrayList<Number>();
		List<Integer> intList = new ArrayList<Integer>();

		print3(objList);
		print3(numList);
		print3(intList);
	}

	public void print3(List<? super Integer> list) {
		list.add(new Integer(100));	//父类限定通配符优点：可以使用泛型类中的某些方法（参数为泛型的方法）
		Object o = list.get(0);		//父类限定通配符缺点：不能使用泛型类中的某些方法（返回值为泛型的方法）
	}

}
